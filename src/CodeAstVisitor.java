import gen.CodeParser;
import gen.CodeVisitor;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CodeAstVisitor extends AbstractParseTreeVisitor<Map<String, Object>>
        implements CodeVisitor<Map<String, Object>> {

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Object> visitProgram(CodeParser.ProgramContext ctx) {
        Map<String, Object>[] statements = new Map[ctx.statement().size()];
        for (int i = 0; i < statements.length; i++) {
            statements[i] = visit(ctx.statement(i));
        }

        return Map.of("type", "Program", "sourceType", "script", "body", statements);
    }

    @Override
    protected Map<String, Object> aggregateResult(
            Map<String, Object> aggregate, Map<String, Object> nextResult) {
        if (aggregate == null) {
            return nextResult;
        }

        if (nextResult == null) {
            return aggregate;
        }
        System.out.println("agg: " + aggregate);
        System.out.println("next: " + nextResult);
        System.out.println("^ should be aggregated ^");
        return nextResult;
    }

    @Override
    public Map<String, Object> visitStatement(CodeParser.StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Map<String, Object> visitExpressionStatement(CodeParser.ExpressionStatementContext ctx) {
        return Map.of("type", "ExpressionStatement", "expression", visit(ctx.expression()));
    }

    @Override
    public Map<String, Object> visitExpression(CodeParser.ExpressionContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Map<String, Object> visitFunctionCall(CodeParser.FunctionCallContext ctx) {
        return visitChildren(ctx);
    }

    public Map<String, Object> visitFunctionCall(
            CodeParser.FunctionCallContext ctx, Map<String, Object> payload) {
        if (ctx.regularFunctionCall() != null) {
            return visitRegularFunctionCall(ctx.regularFunctionCall(), payload);
        } else if (ctx.imposterFunctionCall() != null) {
            return visitImposterFunctionCall(ctx.imposterFunctionCall(), payload);
        }
        return visitChainedFunctionCall(ctx.chainedFunctionCall(), payload);
    }

    @Override
    public Map<String, Object> visitRegularFunctionCall(CodeParser.RegularFunctionCallContext ctx) {
        Object[] args = new Object[ctx.functionArg().size()];
        for (int i = 0; i < args.length; i++) {
            args[i] = visit(ctx.functionArg(i));
        }
        return Map.of("type", "CallExpression", "callee", visit(ctx.accessor()), "arguments", args);
    }

    public Map<String, Object> visitRegularFunctionCall(
            CodeParser.RegularFunctionCallContext ctx, Map<String, Object> payload) {
        Object[] args = new Object[ctx.functionArg().size() + 1];
        args[0] = payload;
        for (int i = 1; i < args.length; i++) {
            args[i] = visit(ctx.functionArg(i - 1));
        }
        return Map.of("type", "CallExpression", "callee", visit(ctx.accessor()), "arguments", args);
    }

    @Override
    public Map<String, Object> visitChainedFunctionCall(CodeParser.ChainedFunctionCallContext ctx) {
        // get first accessor literal
        CodeParser.AccessorContext firstAccessor =
                ctx.accessor() != null ? ctx.accessor() : ctx.regularFunctionCall().accessor();
        // make copy of first accessor and put the second function's accessor as its tail
        CodeParser.AccessorContext secondAccessor;
        if (ctx.functionCall().regularFunctionCall() != null) {
            secondAccessor = ctx.functionCall().regularFunctionCall().accessor();
        } else if (ctx.functionCall().imposterFunctionCall() != null) {
            secondAccessor = ctx.functionCall().imposterFunctionCall().regularFunctionCall().accessor();
        } else {
            secondAccessor = ctx.functionCall().chainedFunctionCall().regularFunctionCall().accessor();
        }
        // replace accessor of second func
        CodeParser.AccessorContext newAccessor =
                new CodeParser.AccessorContext(secondAccessor.getParent(), secondAccessor.invokingState);
        newAccessor.addChild(secondAccessor);
        newAccessor.addChild(firstAccessor.literal());
        secondAccessor.getParent().children.add(0, newAccessor);
        return Map.of(
                "type",
                "BinaryExpression",
                "operator",
                "+",
                "left",
                visit(ctx.accessor() != null ? ctx.accessor() : ctx.regularFunctionCall()),
                "right",
                visit(ctx.functionCall()));
    }

    public Map<String, Object> visitChainedFunctionCall(CodeParser.ChainedFunctionCallContext ctx, Map<String, Object> payload) {
        // get first accessor literal
        CodeParser.AccessorContext firstAccessor = ctx.regularFunctionCall().accessor();
        // make copy of first accessor and put the second function's accessor as its tail
        CodeParser.AccessorContext secondAccessor;
        if (ctx.functionCall().regularFunctionCall() != null) {
            secondAccessor = ctx.functionCall().regularFunctionCall().accessor();
        } else if (ctx.functionCall().imposterFunctionCall() != null) {
            secondAccessor = ctx.functionCall().imposterFunctionCall().regularFunctionCall().accessor();
        } else {
            secondAccessor = ctx.functionCall().chainedFunctionCall().regularFunctionCall().accessor();
        }
        // replace accessor of second func
        CodeParser.AccessorContext newAccessor =
                new CodeParser.AccessorContext(secondAccessor.getParent(), secondAccessor.invokingState);
        newAccessor.addChild(secondAccessor);
        newAccessor.addChild(firstAccessor.literal());
        secondAccessor.getParent().children.add(0, newAccessor);
        return Map.of(
                "type",
                "BinaryExpression",
                "operator",
                "+",
                "left",
                visitRegularFunctionCall(ctx.regularFunctionCall(), payload),
                "right",
                visit(ctx.functionCall())); // CHANGE TO SEQUENCE EXPRESSION!!!!!!!!!!!!!!!!!!!
    }

    @Override
    public Map<String, Object> visitImposterFunctionCall(CodeParser.ImposterFunctionCallContext ctx) {
        Map<String, Object> left =
                ctx.accessor() != null ? visit(ctx.accessor()) : visit(ctx.regularFunctionCall());
        return visitFunctionCall(ctx.functionCall(), left);
    }

    public Map<String, Object> visitImposterFunctionCall(
            CodeParser.ImposterFunctionCallContext ctx, Map<String, Object> payload) {
        if (ctx.regularFunctionCall() == null) {
            System.out.println("imposter function had no regular function call");
        }
        Map<String, Object> left = visitRegularFunctionCall(ctx.regularFunctionCall(), payload);
        return visitFunctionCall(ctx.functionCall(), left);
    }

    @Override
    public Map<String, Object> visitAnonFuncDef(CodeParser.AnonFuncDefContext ctx) {
        return Map.of(
                "type",
                "FunctionExpression",
                "params",
                getAnonParams(Integer.parseInt(ctx.NUM().getText())),
                "body",
                visit(ctx.block()));
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object>[] getAnonParams(int count) {
        Map<String, Object>[] ret = new Map[count];
        for (int i = 0; i < count; i++) {
            ret[i] = Map.of("type", "Identifier", "name", "anon" + count);
        }
        return ret;
    }

    @Override
    public Map<String, Object> visitFunctionArg(CodeParser.FunctionArgContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Map<String, Object> visitSpreadElement(CodeParser.SpreadElementContext ctx) {
        return Map.of("type", "SpreadElement", "argument", visit(ctx.expression()));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Object> visitBlock(CodeParser.BlockContext ctx) {
        Map<String, Object>[] statements = new Map[ctx.statement().size()];
        for (int i = 0; i < statements.length; i++) {
            statements[i] = visit(ctx.statement(i));
        }
        return Map.of("type", "BlockStatement", "body", statements);
    }

    @Override
    public Map<String, Object> visitLiteral(CodeParser.LiteralContext ctx) {
        if (ctx.STRING() != null) {
            return Map.of(
                    "type",
                    "Literal",
                    "value",
                    ctx.STRING().getText().substring(1, ctx.STRING().getText().length() - 1),
                    "raw",
                    ctx.STRING().getText());
        }
        if (ctx.NUM() != null) {
            return Map.of(
                    "type",
                    "Literal",
                    "value",
                    Double.parseDouble(ctx.NUM().getText()),
                    "raw",
                    ctx.NUM().getText());
        }
        return visitChildren(ctx);
    }

    @Override
    public Map<String, Object> visitIdentifier(CodeParser.IdentifierContext ctx) {
        return Map.of("type", "Identifier", "name", ctx.IDENTIFIER().getText());
    }

    @Override
    public Map<String, Object> visitAnonIdentifier(CodeParser.AnonIdentifierContext ctx) {
        return Map.of(
                "type", "Identifier", "name", "anon" + ctx.ANON_IDENTIFIER().getText().substring(1));
    }

    @Override
    public Map<String, Object> visitThisLiteral(CodeParser.ThisLiteralContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitParentLiteral(CodeParser.ParentLiteralContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitUnaryExpr(CodeParser.UnaryExprContext ctx) {
        if (ctx.UNARY_OPERATOR() != null) {
            return Map.of(
                    "type",
                    "UnaryExpression",
                    "operator",
                    ctx.UNARY_OPERATOR().getText(),
                    "argument",
                    visit(ctx.expression()),
                    "prefix",
                    true);
        }
        return Map.of(
                "type",
                "UpdateExpression",
                "operator",
                ctx.POST_UNARY_OPERATOR().getText(),
                "argument",
                visit(ctx.accessor()));
    }

    @Override
    public Map<String, Object> visitBinaryExpr(CodeParser.BinaryExprContext ctx) {
        return Map.of(
                "type",
                "BinaryExpression",
                "operator",
                ctx.BINARY_OPERATOR().getText(),
                "left",
                visit(ctx.accessor() != null ? ctx.accessor() : ctx.functionCall()),
                "right",
                visit(ctx.expression()));
    }

    @Override
    public Map<String, Object> visitLogicExpr(CodeParser.LogicExprContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitTernaryExpr(CodeParser.TernaryExprContext ctx) {
        return null; // Map.of("type", "ConditionalExpression", "test", visit(ctx.));
    }

    @Override
    public Map<String, Object> visitNewExpression(CodeParser.NewExpressionContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitWaitforExpression(CodeParser.WaitforExpressionContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitAccessor(CodeParser.AccessorContext ctx) {
    /*
    if no payload, make payload of two first literals
    if no following accessor, make map and return
    make map and return visit(ctx.accessor(), payload)
     */
        if (ctx.accessor() == null) {
            return visit(ctx.literal());
        }
        return visitAccessor(
                ctx.accessor().accessor(),
                Map.of(
                        "type",
                        "MemberExpression",
                        "object",
                        visit(ctx.literal()),
                        "property",
                        visit(ctx.accessor().literal())));
    }

    public Map<String, Object> visitAccessor(
            CodeParser.AccessorContext ctx, Map<String, Object> payload) {
        if (ctx == null) return payload;
        Map<String, Object> ret =
                Map.of("type", "MemberExpression", "object", payload, "property", visit(ctx.literal()));
        if (ctx.accessor() == null) {
            return ret;
        }
        return visitAccessor(ctx.accessor(), ret);
    }

    @Override
    public Map<String, Object> visitAssignmentExpr(CodeParser.AssignmentExprContext ctx) {
        return Map.of(
                "type",
                "AssignmentExpression",
                "operator",
                ctx.ASSIGNMENT_OP().getText(),
                "left",
                visit(ctx.accessor()),
                "right",
                visit(ctx.expression()));
    }

    @Override
    public Map<String, Object> visitAssignmentPattern(CodeParser.AssignmentPatternContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitArrayBindingDec(CodeParser.ArrayBindingDecContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitObjectBindingDec(CodeParser.ObjectBindingDecContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitBindingPattern(CodeParser.BindingPatternContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitArrayExpression(CodeParser.ArrayExpressionContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitArrayExpressionElement(CodeParser.ArrayExpressionElementContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitArrayPattern(CodeParser.ArrayPatternContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitArrayPatternElement(CodeParser.ArrayPatternElementContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitObjectExpression(CodeParser.ObjectExpressionContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitObjectExpressionElement(CodeParser.ObjectExpressionElementContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitObjectPattern(CodeParser.ObjectPatternContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitObjectPatternElement(CodeParser.ObjectPatternElementContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitVariableDeclaration(CodeParser.VariableDeclarationContext ctx) {
        return Map.of(
                "type",
                "VariableDeclaration",
                "declarations",
                new Object[] {
                        Map.of(
                                "type",
                                "VariableDeclarator",
                                "id",
                                visit(ctx.identifier()),
                                "init",
                                visit(ctx.expression()))
                },
                "kind",
                ctx.DECLARATION_OP().getText().equals(":=") ? "let" : "const");
    }

    @Override
    public Map<String, Object> visitVariableDeclarator(CodeParser.VariableDeclaratorContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitNestedStatement(CodeParser.NestedStatementContext ctx) {
        return visit(ctx.statement());
    }

    @Override
    public Map<String, Object> visitIfStatement(CodeParser.IfStatementContext ctx) {
        if (ctx.elseBlock() == null) {
            return Map.of(
                    "type",
                    "IfStatement",
                    "test",
                    visit(ctx.expression()),
                    "consequent",
                    visit(ctx.statement()));
        }
        return Map.of(
                "type",
                "IfStatement",
                "test",
                visit(ctx.expression()),
                "consequent",
                visit(ctx.statement()),
                "alternate",
                visit(ctx.elseBlock()));
    }

    @Override
    public Map<String, Object> visitElseBlock(CodeParser.ElseBlockContext ctx) {
        return visit(ctx.statement());
    }

    @Override
    public Map<String, Object> visitWhileStatement(CodeParser.WhileStatementContext ctx) {
        return Map.of(
                "type", "WhileStatement", "test", visit(ctx.expression()), "body", visit(ctx.statement()));
    }

    @Override
    public Map<String, Object> visitDoWhileStatement(CodeParser.DoWhileStatementContext ctx) {
        return Map.of(
                "type",
                "DoWhileStatement",
                "test",
                visit(ctx.expression()),
                "body",
                visit(ctx.statement()));
    }

    @Override
    public Map<String, Object> visitForStatement(CodeParser.ForStatementContext ctx) {
        Map<String, Object> init =
                ctx.variableDeclaration() != null
                        ? visit(ctx.variableDeclaration())
                        : visit(ctx.expression(0));
        int n = ctx.expression().size();
        return Map.of(
                "type",
                "ForStatement",
                "init",
                init,
                "test",
                visit(ctx.expression(n - 2)),
                "update",
                visit(ctx.expression(n - 1)),
                "body",
                visit(ctx.statement()));
    }

    @Override
    public Map<String, Object> visitForIndexedStatement(CodeParser.ForIndexedStatementContext ctx) {
        return Map.of(
                "type",
                "ForInStatement",
                "left",
                visit(ctx.identifier()),
                "right",
                visit(ctx.expression()),
                "body",
                visit(ctx.statement()));
    }

    @Override
    public Map<String, Object> visitForEachStatement(CodeParser.ForEachStatementContext ctx) {
        return Map.of(
                "type",
                "ForOfStatement",
                "left",
                visit(ctx.identifier()),
                "right",
                visit(ctx.expression()),
                "body",
                visit(ctx.statement()));
    }

    @Override
    public Map<String, Object> visitSkipStatement(CodeParser.SkipStatementContext ctx) {
        return Map.of("type", "ContinueStatement");
    }

    @Override
    public Map<String, Object> visitBreakStatement(CodeParser.BreakStatementContext ctx) {
        return Map.of("type", "BreakStatement");
    }

    @Override
    public Map<String, Object> visitThrowStatement(CodeParser.ThrowStatementContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitGuardStatement(CodeParser.GuardStatementContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitFromClause(CodeParser.FromClauseContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitEndwithClause(CodeParser.EndwithClauseContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitLogicStatementTest(CodeParser.LogicStatementTestContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitMatchStatement(CodeParser.MatchStatementContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitMatchBody(CodeParser.MatchBodyContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitFullMatchClause(CodeParser.FullMatchClauseContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitShortMatchClause(CodeParser.ShortMatchClauseContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitMatchExpression(CodeParser.MatchExpressionContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitMatchExpressionBody(CodeParser.MatchExpressionBodyContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitMatchExpressionClause(CodeParser.MatchExpressionClauseContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitCondStatement(CodeParser.CondStatementContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitCondBody(CodeParser.CondBodyContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitCondClause(CodeParser.CondClauseContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitCondExpression(CodeParser.CondExpressionContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitCondExpressionBody(CodeParser.CondExpressionBodyContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitCondExpressionClause(CodeParser.CondExpressionClauseContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitClassDeclaration(CodeParser.ClassDeclarationContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitClassParentDeclaration(CodeParser.ClassParentDeclarationContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitClassBody(CodeParser.ClassBodyContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitMethodDef(CodeParser.MethodDefContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitCtorDef(CodeParser.CtorDefContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitMethodAnnotations(CodeParser.MethodAnnotationsContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitMethodBody(CodeParser.MethodBodyContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitImportDeclaration(CodeParser.ImportDeclarationContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitDefaultImport(CodeParser.DefaultImportContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitAllImport(CodeParser.AllImportContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitSpecificImport(CodeParser.SpecificImportContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitExportDeclaration(CodeParser.ExportDeclarationContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitExportAllDeclaration(CodeParser.ExportAllDeclarationContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitExportDefaultDeclaration(CodeParser.ExportDefaultDeclarationContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitExportNamedDeclaration(CodeParser.ExportNamedDeclarationContext ctx) {
        return null;
    }

    @Override
    public Map<String, Object> visitExportSpecifier(CodeParser.ExportSpecifierContext ctx) {
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Object> visitFunctionDeclaration(CodeParser.FunctionDeclarationContext ctx) {
        Map<String, Object> ret =
                ctx.functionAnnotations() != null ? visit(ctx.functionAnnotations()) : new HashMap<>();
        ret.put("type", "FunctionDeclaration");
        ret.put("id", visit(ctx.identifier()));
        Map<String, Object>[] params = new Map[ctx.functionParam().size()];
        for (int i = 0; i < params.length; i++) {
            params[i] = visit(ctx.functionParam(i));
        }
        ret.put("params", params);
        ret.put("body", visit(ctx.functionBody()));
        return ret;
    }

    @Override
    public Map<String, Object> visitFunctionAnnotations(CodeParser.FunctionAnnotationsContext ctx) {
        Map<String, Object> ret = new HashMap<>();
        for (TerminalNode x : ctx.FUNCTION_ANNOTATION()) {
            ret.put(x.getText().substring(1), true);
        }
        return ret;
    }

    @Override
    public Map<String, Object> visitFunctionParam(CodeParser.FunctionParamContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Map<String, Object> visitFunctionParamAssign(CodeParser.FunctionParamAssignContext ctx) {
        return Map.of(
                "type",
                "AssignmentPattern",
                "left",
                visit(ctx.identifier()),
                "right",
                visit(ctx.expression()));
    }

    @Override
    public Map<String, Object> visitFunctionBody(CodeParser.FunctionBodyContext ctx) {
        if (ctx.block() != null) return visit(ctx.block());
        return Map.of("type", "ReturnStatement", "argument", visit(ctx.expression()));
    }

    @Override
    public Map<String, Object> visitReturnStatement(CodeParser.ReturnStatementContext ctx) {
        return Map.of("type", "ReturnStatement", "argument", visit(ctx.expression()));
    }

    @Override
    public Map<String, Object> visitGenerateExpression(CodeParser.GenerateExpressionContext ctx) {
        return Map.of("type", "yieldExpression", "argument", visit(ctx.expression()));
    }
}

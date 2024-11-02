import gen.CodeParser;
import gen.CodeVisitor;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CodeAstVisitor extends AbstractParseTreeVisitor<Map<String, Object>>
    implements CodeVisitor<Map<String, Object>> {

  @Override
  @SuppressWarnings("unchecked")
  public Map<String, Object> visitProgram(CodeParser.ProgramContext ctx) {
    Map<String, Object>[] statements = new Map[ctx.statement().size()];
    for (int i = 0; i < statements.length; i++) {
      statements[i] = visit(ctx.statement(i));
    }

    return Map.of("type", "Program", "sourceType", "module", "body", statements);
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

  public Map<String, Object> visitChainedFunctionCall(
      CodeParser.ChainedFunctionCallContext ctx, Map<String, Object> payload) {
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
        "SequenceExpression",
        "expressions",
        new Object[] {
          visitRegularFunctionCall(ctx.regularFunctionCall(), payload), visit(ctx.functionCall())
        });
    /*return Map.of(
    "type",
    "BinaryExpression",
    "operator",
    "+",
    "left",
    visitRegularFunctionCall(ctx.regularFunctionCall(), payload),
    "right",
    visit(ctx.functionCall())); // CHANGE TO SEQUENCE EXPRESSION!!!!!!!!!!!!!!!!!!!*/
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
      ret[i] = Map.of("type", "Identifier", "name", "__ANON" + count);
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
        "type", "Identifier", "name", "__ANON" + ctx.ANON_IDENTIFIER().getText().substring(1));
  }

  @Override
  public Map<String, Object> visitThisLiteral(CodeParser.ThisLiteralContext ctx) {
    return Map.of("type", "ThisExpression");
  }

  @Override
  public Map<String, Object> visitParentLiteral(CodeParser.ParentLiteralContext ctx) {
    return Map.of("type", "Super");
  }

  @Override
  public Map<String, Object> visitNilLiteral(CodeParser.NilLiteralContext ctx) {
    Map<String, Object> ret = new HashMap<>();
    ret.put("type", "Literal");
    ret.put("value", null);
    ret.put("raw", "null");
    return ret;
  }

  @Override
  public Map<String, Object> visitBooleanLiteral(CodeParser.BooleanLiteralContext ctx) {
    return Map.of(
        "type",
        "Literal",
        "value",
        ctx.getChild(0).getText().equals("true"),
        "raw",
        ctx.getChild(0).getText());
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
    return Map.of(
        "type",
        "LogicalExpression",
        "operator",
        ctx.BINARY_LOGIC_OP().getText(),
        "left",
        visit(ctx.accessor() != null ? ctx.accessor() : ctx.functionCall()),
        "right",
        visit(ctx.expression()));
  }

  @Override
  public Map<String, Object> visitTernaryExpr(CodeParser.TernaryExprContext ctx) {
    return Map.of(
        "type",
        "ConditionalExpression",
        "test",
        visit(ctx.expression(0)),
        "consequent",
        visit(ctx.expression(1)),
        "alternate",
        visit(ctx.expression(2)));
  }

  @Override
  public Map<String, Object> visitNewExpression(CodeParser.NewExpressionContext ctx) {
    Object[] args = new Object[ctx.functionArg().size()];
    for (int i = 0; i < args.length; i++) {
      args[i] = visit(ctx.functionArg(i));
    }
    return Map.of("type", "NewExpression", "callee", visit(ctx.accessor()), "arguments", args);
  }

  @Override
  public Map<String, Object> visitWaitforExpression(CodeParser.WaitforExpressionContext ctx) {
    return Map.of("type", "AwaitExpression", "argument", visit(ctx.expression()));
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
    return Map.of(
        "type",
        "AssignmentPattern",
        "left",
        visit(ctx.identifier()),
        "right",
        visit(ctx.expression()));
  }

  @Override
  public Map<String, Object> visitBindingDeclaration(CodeParser.BindingDeclarationContext ctx) {
    return visitChildren(ctx);
  }

  @Override
  public Map<String, Object> visitArrayBindingDec(CodeParser.ArrayBindingDecContext ctx) {
    return Map.of(
        "type",
        "VariableDeclarator",
        "id",
        visit(ctx.arrayPattern()),
        "init",
        visit(ctx.expression()));
  }

  @Override
  public Map<String, Object> visitObjectBindingDec(CodeParser.ObjectBindingDecContext ctx) {
    return Map.of(
        "type",
        "VariableDeclarator",
        "id",
        visit(ctx.objectPattern()),
        "init",
        visit(ctx.expression()));
  }

  @Override
  public Map<String, Object> visitBindingPattern(CodeParser.BindingPatternContext ctx) {
    return visitChildren(ctx);
  }

  @Override
  public Map<String, Object> visitArrayExpression(CodeParser.ArrayExpressionContext ctx) {
    Object[] elems = new Object[ctx.arrayExpressionElement().size()];
    for (int i = 0; i < elems.length; i++) {
      elems[i] = visit(ctx.arrayExpressionElement(i));
    }
    return Map.of("type", "ArrayExpression", "elements", elems);
  }

  @Override
  public Map<String, Object> visitArrayExpressionElement(
      CodeParser.ArrayExpressionElementContext ctx) {
    return visit(ctx.expression());
  }

  @Override
  public Map<String, Object> visitArrayPattern(CodeParser.ArrayPatternContext ctx) {
    Object[] elems = new Object[ctx.arrayPatternElement().size()];
    for (int i = 0; i < elems.length; i++) {
      elems[i] = visit(ctx.arrayPatternElement(i));
    }
    return Map.of("type", "ArrayPattern", "elements", elems);
  }

  @Override
  public Map<String, Object> visitArrayPatternElement(CodeParser.ArrayPatternElementContext ctx) {
    return visitChildren(ctx);
  }

  @Override
  public Map<String, Object> visitObjectExpression(CodeParser.ObjectExpressionContext ctx) {
    Object[] elems = new Object[ctx.objectExpressionElement().size()];
    for (int i = 0; i < elems.length; i++) {
      elems[i] = visit(ctx.objectExpressionElement(i));
    }
    return Map.of("type", "ObjectExpression", "properties", elems);
  }

  @Override
  public Map<String, Object> visitObjectExpressionElement(
      CodeParser.ObjectExpressionElementContext ctx) {
    boolean isShorthand = ctx.expression() == null;
    return Map.of(
        "type",
        "Property",
        "key",
        visit(ctx.literal()),
        "value",
        isShorthand ? visit(ctx.literal()) : visit(ctx.expression()),
        "shorthand",
        isShorthand,
        "method",
        false,
        "kind",
        "init");
  }

  @Override
  public Map<String, Object> visitObjectPattern(CodeParser.ObjectPatternContext ctx) {
    Object[] elems = new Object[ctx.objectPatternElement().size()];
    for (int i = 0; i < elems.length; i++) {
      elems[i] = visit(ctx.objectPatternElement(i));
    }
    return Map.of("type", "ObjectPattern", "properties", elems);
  }

  @Override
  public Map<String, Object> visitObjectPatternElement(CodeParser.ObjectPatternElementContext ctx) {
    boolean isShorthand = ctx.expression() == null;
    return Map.of(
        "type",
        "Property",
        "key",
        visit(ctx.literal()),
        "value",
        isShorthand ? visit(ctx.literal()) : visit(ctx.expression()),
        "shorthand",
        isShorthand,
        "method",
        false,
        "kind",
        "init");
  }

  @Override
  public Map<String, Object> visitVariableDeclaration(CodeParser.VariableDeclarationContext ctx) {
    return Map.of(
        "type",
        "VariableDeclaration",
        "declarations",
        new Object[] {
          ctx.variableDeclarator() != null
              ? visit(ctx.variableDeclarator())
              : visit(ctx.bindingDeclaration())
        },
        "kind",
        hasLetOperator(ctx) ? "let" : "const");
  }

  private boolean hasLetOperator(CodeParser.VariableDeclarationContext ctx) {
    return ctx.variableDeclarator() != null
        ? hasLetOperator(ctx.variableDeclarator())
        : hasLetOperator(ctx.bindingDeclaration());
  }

  private boolean hasLetOperator(CodeParser.VariableDeclaratorContext ctx) {
    return ctx.DECLARATION_OP().getText().equals(":=");
  }

  private boolean hasLetOperator(CodeParser.BindingDeclarationContext ctx) {
    return ctx.arrayBindingDec() != null
        ? hasLetOperator(ctx.arrayBindingDec())
        : hasLetOperator(ctx.objectBindingDec());
  }

  private boolean hasLetOperator(CodeParser.ArrayBindingDecContext ctx) {
    return ctx.DECLARATION_OP().getText().equals(":=");
  }

  private boolean hasLetOperator(CodeParser.ObjectBindingDecContext ctx) {
    return ctx.DECLARATION_OP().getText().equals(":=");
  }

  @Override
  public Map<String, Object> visitVariableDeclarator(CodeParser.VariableDeclaratorContext ctx) {
    return Map.of(
        "type",
        "VariableDeclarator",
        "id",
        visit(ctx.identifier()),
        "init",
        visit(ctx.expression()));
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
    return Map.of("type", "ThrowStatement", "argument", visit(ctx.expression()));
  }

  @Override
  public Map<String, Object> visitGuardStatement(CodeParser.GuardStatementContext ctx) {
    Map<String, Object> ret = new HashMap<>();
    ret.put("type", "TryStatement");
    ret.put("block", visit(ctx.block()));
    ret.put("handler", ctx.fromClause() != null ? visit(ctx.fromClause()) : null);
    ret.put("finalizer", ctx.endwithClause() != null ? visit(ctx.endwithClause()) : null);
    return ret;
  }

  @Override
  public Map<String, Object> visitFromClause(CodeParser.FromClauseContext ctx) {
    return Map.of(
        "type",
        "CatchClause",
        "param",
        ctx.identifier() != null
            ? visit(ctx.identifier())
            : Map.of("type", "Identifier", "name", "__EXC"),
        "body",
        visit(ctx.block()));
  }

  @Override
  public Map<String, Object> visitEndwithClause(CodeParser.EndwithClauseContext ctx) {
    return visit(ctx.block());
  }

  @Override
  public Map<String, Object> visitLogicStatementTest(CodeParser.LogicStatementTestContext ctx) {
    Map<String, Object> ret = new HashMap<>();
    ret.put("test", ctx.expression() != null ? visit(ctx.expression()) : null);
    return ret;
  }

  @Override
  public Map<String, Object> visitMatchStatement(CodeParser.MatchStatementContext ctx) {
    return Map.of(
        "type",
        "SwitchStatement",
        "discriminant",
        visit(ctx.expression()),
        "cases",
        visit(ctx.matchBody()).get("cases"));
  }

  @Override
  public Map<String, Object> visitMatchBody(CodeParser.MatchBodyContext ctx) {
    Object[] cases = new Object[ctx.matchClause().size()];
    for (int i = 0; i < cases.length; i++) {
      cases[i] = visit(ctx.matchClause(i));
    }
    return Map.of("cases", cases);
  }

  @Override
  public Map<String, Object> visitFullMatchClause(CodeParser.FullMatchClauseContext ctx) {
    Map<String, Object> ret = new HashMap<>();
    ret.put("type", "SwitchCase");
    ret.put("test", visit(ctx.logicStatementTest()).get("test"));
    ret.put("consequent", new Object[] {visit(ctx.statement())});
    return ret;
  }

  @Override
  public Map<String, Object> visitShortMatchClause(CodeParser.ShortMatchClauseContext ctx) {
    Map<String, Object> ret = new HashMap<>();
    ret.put("type", "SwitchCase");
    ret.put("test", visit(ctx.logicStatementTest()).get("test"));
    ret.put("consequent", new Object[] {visit(ctx.statement()), Map.of("type", "BreakStatement")});
    return ret;
  }

  @Override
  public Map<String, Object> visitMatchExpression(CodeParser.MatchExpressionContext ctx) {
    // making an IIFE that returns the result of the matched clause
    return Map.of(
        "type",
        "CallExpression",
        "arguments",
        new Object[] {},
        "callee",
        Map.of(
            "type",
            "FunctionExpression",
            "params",
            new Object[] {},
            "body",
            Map.of(
                "type",
                "BlockStatement",
                "body",
                new Object[] {
                  Map.of(
                      "type",
                      "SwitchStatement",
                      "discriminant",
                      visit(ctx.expression()),
                      "cases",
                      visit(ctx.matchExpressionBody()).get("cases"))
                })));
  }

  @Override
  public Map<String, Object> visitMatchExpressionBody(CodeParser.MatchExpressionBodyContext ctx) {
    Object[] cases = new Object[ctx.matchExpressionClause().size()];
    for (int i = 0; i < cases.length; i++) {
      cases[i] = visit(ctx.matchExpressionClause(i));
    }
    return Map.of("cases", cases);
  }

  @Override
  public Map<String, Object> visitMatchExpressionClause(
      CodeParser.MatchExpressionClauseContext ctx) {
    Map<String, Object> ret = new HashMap<>();
    ret.put("type", "SwitchCase");
    ret.put("test", visit(ctx.logicStatementTest()).get("test"));
    ret.put(
        "consequent",
        new Object[] {Map.of("type", "ReturnStatement", "argument", visit(ctx.expression()))});
    return ret;
  }

  @Override
  public Map<String, Object> visitCondStatement(CodeParser.CondStatementContext ctx) {
    return visitChildren(ctx);
  }

  @Override
  @SuppressWarnings("unchecked")
  public Map<String, Object> visitCondBody(CodeParser.CondBodyContext ctx) {
    int numClauses = ctx.condClause().size();
    Map<String, Object> ret = visit(ctx.condClause(0));
    Map<String, Object> curr = ret;
    for (int i = 1; i < numClauses; i++) {
      curr.put("alternate", visit(ctx.condClause(i)));
      curr = (Map<String, Object>) curr.get("alternate");
    }
    return ret;
  }

  @Override
  public Map<String, Object> visitCondClause(CodeParser.CondClauseContext ctx) {
    Object test = visit(ctx.logicStatementTest()).get("test");
    if (test == null) {
      return visit(ctx.statement());
    }
    Map<String, Object> ret = new HashMap<>();
    ret.put("type", "IfStatement");
    ret.put("test", test);
    ret.put("consequent", visit(ctx.statement()));
    return ret;
  }

  @Override
  public Map<String, Object> visitCondExpression(CodeParser.CondExpressionContext ctx) {
    // making an IIFE that returns the result of the matched clause
    return Map.of(
        "type",
        "CallExpression",
        "arguments",
        new Object[] {},
        "callee",
        Map.of(
            "type",
            "FunctionExpression",
            "params",
            new Object[] {},
            "body",
            Map.of(
                "type",
                "BlockStatement",
                "body",
                visit(ctx.condExpressionBody()).get("clauses"))));
  }

  @Override
  public Map<String, Object> visitCondExpressionBody(CodeParser.CondExpressionBodyContext ctx) {
    Object[] clauses = new Object[ctx.condExpressionClause().size()];
    for (int i = 0; i < clauses.length; i++) {
      clauses[i] = visit(ctx.condExpressionClause(i));
    }
    return Map.of("clauses", clauses);
  }

  @Override
  public Map<String, Object> visitCondExpressionClause(CodeParser.CondExpressionClauseContext ctx) {
    Object test = visit(ctx.logicStatementTest()).get("test");
    if (test == null) {
      return Map.of("type", "ReturnStatement", "argument", visit(ctx.expression()));
    }
    Map<String, Object> ret = new HashMap<>();
    ret.put("type", "IfStatement");
    ret.put("test", test);
    ret.put(
        "consequent",
        Map.of("type", "ReturnStatement", "argument", visit(ctx.expression())));
    return ret;
  }

  @Override
  public Map<String, Object> visitClassDeclaration(CodeParser.ClassDeclarationContext ctx) {
    Map<String, Object> ret = new HashMap<>();
    ret.put("type", "ClassDeclaration");
    ret.put("id", visit(ctx.identifier()));
    if (ctx.classParentDeclaration() != null)
      ret.put("superClass", visit(ctx.classParentDeclaration()));
    ret.put("body", visit(ctx.classBody()));
    return ret;
  }

  @Override
  public Map<String, Object> visitClassParentDeclaration(
      CodeParser.ClassParentDeclarationContext ctx) {
    return visit(ctx.accessor());
  }

  @Override
  public Map<String, Object> visitClassBody(CodeParser.ClassBodyContext ctx) {
    Object[] methods = new Object[ctx.methodDeclaration().size()];
    for (int i = 0; i < methods.length; i++) {
      methods[i] = visit(ctx.methodDeclaration(i));
    }
    return Map.of("type", "ClassBody", "body", methods);
  }

  @Override
  @SuppressWarnings("unchecked")
  public Map<String, Object> visitMethodDef(CodeParser.MethodDefContext ctx) {
    Map<String, Object> ret = new HashMap<>();
    Map<String, Object> annotations = new HashMap<>();
    if (ctx.methodAnnotations() != null) annotations.putAll(visit(ctx.methodAnnotations()));
    ret.put("static", annotations.getOrDefault("static", false));
    ret.put("kind", "method");
    Map<String, Object>[] params = new Map[ctx.functionParam().size()];
    for (int i = 0; i < params.length; i++) {
      params[i] = visit(ctx.functionParam(i));
    }
    ret.put(
        "value",
        Map.of(
            "type",
            "FunctionExpression",
            "params",
            params,
            "generator",
            annotations.getOrDefault("generator", false),
            "expression",
            false,
            "async",
            annotations.getOrDefault("async", false),
            "body",
            visit(ctx.methodBody())));
    return ret;
  }

  @Override
  @SuppressWarnings("unchecked")
  public Map<String, Object> visitCtorDef(CodeParser.CtorDefContext ctx) {
    Map<String, Object> ret = new HashMap<>();
    ret.put("kind", "constructor");
    Map<String, Object>[] params = new Map[ctx.functionParam().size()];
    for (int i = 0; i < params.length; i++) {
      params[i] = visit(ctx.functionParam(i));
    }
    ret.put(
        "value",
        Map.of("type", "FunctionExpression", "params", params, "body", visit(ctx.methodBody())));
    return ret;
  }

  @Override
  public Map<String, Object> visitMethodAnnotations(CodeParser.MethodAnnotationsContext ctx) {
    Map<String, Object> ret = new HashMap<>();
    for (TerminalNode x : ctx.METHOD_ANNOTATION()) {
      ret.put(x.getText().substring(1), true);
    }
    return ret;
  }

  @Override
  public Map<String, Object> visitMethodBody(CodeParser.MethodBodyContext ctx) {
    if (ctx.block() != null) return visit(ctx.block());
    return Map.of(
        "type",
        "BlockStatement",
        "body",
        new Object[] {Map.of("type", "ReturnStatement", "argument", visit(ctx.expression()))});
  }

  @Override
  public Map<String, Object> visitImportDeclaration(CodeParser.ImportDeclarationContext ctx) {
    Object[] specifiers = new Object[ctx.importSpecifier().size()];
    return Map.of(
        "type",
        "ImportDeclaration",
        "specifiers",
        specifiers,
        "source",
        Map.of(
            "type",
            "Literal",
            "value",
            ctx.STRING().getText().substring(1, ctx.STRING().getText().length() - 1),
            "raw",
            ctx.STRING().getText()));
  }

  @Override
  public Map<String, Object> visitDefaultImport(CodeParser.DefaultImportContext ctx) {
    return Map.of("type", "ImportDefaultSpecifier", "local", visit(ctx.identifier()));
  }

  @Override
  public Map<String, Object> visitAllImport(CodeParser.AllImportContext ctx) {
    return Map.of("type", "ImportNamespaceIdentifier", "local", visit(ctx.identifier()));
  }

  @Override
  public Map<String, Object> visitSpecificImport(CodeParser.SpecificImportContext ctx) {
    boolean hasLocal = ctx.identifier().size() > 1;
    return Map.of(
        "type",
        "ImportSpecifier",
        "local",
        hasLocal ? visit(ctx.identifier(1)) : visit(ctx.identifier(0)),
        "imported",
        visit(ctx.identifier(0)));
  }

  @Override
  public Map<String, Object> visitExportDeclaration(CodeParser.ExportDeclarationContext ctx) {
    return visitChildren(ctx);
  }

  @Override
  public Map<String, Object> visitExportAllDeclaration(CodeParser.ExportAllDeclarationContext ctx) {
    return Map.of(
        "type",
        "ExportAllDeclaration",
        "source",
        Map.of(
            "type",
            "Literal",
            "value",
            ctx.STRING().getText().substring(1, ctx.STRING().getText().length() - 1),
            "raw",
            ctx.STRING().getText()));
  }

  @Override
  public Map<String, Object> visitExportDefaultDeclaration(
      CodeParser.ExportDefaultDeclarationContext ctx) {
    return Map.of("type", "ExportDefaultDeclaration", "declaration", visitChildren(ctx));
  }

  @Override
  public Map<String, Object> visitExportNamedDeclaration(
      CodeParser.ExportNamedDeclarationContext ctx) {
    if (ctx.exportNamedDeclarationSpecifier() != null) {
      return Map.of(
          "type",
          "ExportNamedDeclaration",
          "specifiers",
          new Object[] {},
          "declaration",
          visit(ctx.exportNamedDeclarationSpecifier()));
    }
    Object[] specs = new Object[ctx.exportSpecifier().size()];
    for (int i = 0; i < specs.length; i++) {
      specs[i] = visit(ctx.exportSpecifier(i));
    }
    return Map.of("type", "ExportNamedDeclaration", "specifiers", specs);
  }

  @Override
  public Map<String, Object> visitExportSpecifier(CodeParser.ExportSpecifierContext ctx) {
    return Map.of(
        "type",
        "ExportSpecifier",
        "local",
        visit(ctx.accessor(0)),
        "exported",
        ctx.accessor(1) != null ? visit(ctx.accessor(1)) : visit(ctx.accessor(0)));
  }

  @Override
  public Map<String, Object> visitExportNamedDeclarationSpecifier(
      CodeParser.ExportNamedDeclarationSpecifierContext ctx) {
    return visitChildren(ctx);
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

package gen;// Generated from C:/Users/omerg/IdeaProjects/My Lang/Code.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CodeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CodeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CodeParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CodeParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CodeParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(CodeParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CodeParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CodeParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#nestedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedStatement(CodeParser.NestedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(CodeParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#regularFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRegularFunctionCall(CodeParser.RegularFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#chainedFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChainedFunctionCall(CodeParser.ChainedFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#imposterFunctionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImposterFunctionCall(CodeParser.ImposterFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#functionArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArg(CodeParser.FunctionArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#anonFuncDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonFuncDef(CodeParser.AnonFuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(CodeParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#functionAnnotations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionAnnotations(CodeParser.FunctionAnnotationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#functionParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParam(CodeParser.FunctionParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(CodeParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(CodeParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#generateExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenerateExpression(CodeParser.GenerateExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(CodeParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(CodeParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#anonIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonIdentifier(CodeParser.AnonIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#thisLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisLiteral(CodeParser.ThisLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#parentLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentLiteral(CodeParser.ParentLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#accessor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessor(CodeParser.AccessorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#spreadElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpreadElement(CodeParser.SpreadElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(CodeParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#variableDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarator(CodeParser.VariableDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#assignmentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpr(CodeParser.AssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#assignmentPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentPattern(CodeParser.AssignmentPatternContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayBindingDec}
	 * labeled alternative in {@link CodeParser#bindingDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayBindingDec(CodeParser.ArrayBindingDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectBindingDec}
	 * labeled alternative in {@link CodeParser#bindingDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectBindingDec(CodeParser.ObjectBindingDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#bindingPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBindingPattern(CodeParser.BindingPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#arrayExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpression(CodeParser.ArrayExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#arrayExpressionElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpressionElement(CodeParser.ArrayExpressionElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#arrayPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayPattern(CodeParser.ArrayPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#arrayPatternElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayPatternElement(CodeParser.ArrayPatternElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#objectExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectExpression(CodeParser.ObjectExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#objectExpressionElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectExpressionElement(CodeParser.ObjectExpressionElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#objectPattern}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectPattern(CodeParser.ObjectPatternContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#objectPatternElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectPatternElement(CodeParser.ObjectPatternElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(CodeParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#binaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(CodeParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#logicExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr(CodeParser.LogicExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#ternaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpr(CodeParser.TernaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#newExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(CodeParser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#waitforExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWaitforExpression(CodeParser.WaitforExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(CodeParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#elseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBlock(CodeParser.ElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(CodeParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#doWhileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStatement(CodeParser.DoWhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(CodeParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#forIndexedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForIndexedStatement(CodeParser.ForIndexedStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#forEachStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForEachStatement(CodeParser.ForEachStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#skipStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkipStatement(CodeParser.SkipStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(CodeParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(CodeParser.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#guardStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGuardStatement(CodeParser.GuardStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#fromClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromClause(CodeParser.FromClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#endwithClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndwithClause(CodeParser.EndwithClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#logicStatementTest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicStatementTest(CodeParser.LogicStatementTestContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#matchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchStatement(CodeParser.MatchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#matchBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchBody(CodeParser.MatchBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FullMatchClause}
	 * labeled alternative in {@link CodeParser#matchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullMatchClause(CodeParser.FullMatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ShortMatchClause}
	 * labeled alternative in {@link CodeParser#matchClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShortMatchClause(CodeParser.ShortMatchClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#matchExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchExpression(CodeParser.MatchExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#matchExpressionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchExpressionBody(CodeParser.MatchExpressionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#matchExpressionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatchExpressionClause(CodeParser.MatchExpressionClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#condStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondStatement(CodeParser.CondStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#condBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondBody(CodeParser.CondBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#condClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondClause(CodeParser.CondClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#condExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExpression(CodeParser.CondExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#condExpressionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExpressionBody(CodeParser.CondExpressionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#condExpressionClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExpressionClause(CodeParser.CondExpressionClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(CodeParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#classParentDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassParentDeclaration(CodeParser.ClassParentDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(CodeParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodDef}
	 * labeled alternative in {@link CodeParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDef(CodeParser.MethodDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CtorDef}
	 * labeled alternative in {@link CodeParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtorDef(CodeParser.CtorDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#methodAnnotations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodAnnotations(CodeParser.MethodAnnotationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(CodeParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(CodeParser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefaultImport}
	 * labeled alternative in {@link CodeParser#importSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultImport(CodeParser.DefaultImportContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AllImport}
	 * labeled alternative in {@link CodeParser#importSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllImport(CodeParser.AllImportContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SpecificImport}
	 * labeled alternative in {@link CodeParser#importSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecificImport(CodeParser.SpecificImportContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#exportDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportDeclaration(CodeParser.ExportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#exportAllDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportAllDeclaration(CodeParser.ExportAllDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#exportDefaultDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportDefaultDeclaration(CodeParser.ExportDefaultDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#exportNamedDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportNamedDeclaration(CodeParser.ExportNamedDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#exportSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportSpecifier(CodeParser.ExportSpecifierContext ctx);
}
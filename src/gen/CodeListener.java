package gen;// Generated from C:/Users/omerg/IdeaProjects/My Lang/Code.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CodeParser}.
 */
public interface CodeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CodeParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CodeParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CodeParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CodeParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CodeParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(CodeParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(CodeParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CodeParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CodeParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CodeParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CodeParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#nestedStatement}.
	 * @param ctx the parse tree
	 */
	void enterNestedStatement(CodeParser.NestedStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#nestedStatement}.
	 * @param ctx the parse tree
	 */
	void exitNestedStatement(CodeParser.NestedStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(CodeParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(CodeParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#regularFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterRegularFunctionCall(CodeParser.RegularFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#regularFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitRegularFunctionCall(CodeParser.RegularFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#chainedFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterChainedFunctionCall(CodeParser.ChainedFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#chainedFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitChainedFunctionCall(CodeParser.ChainedFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#imposterFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterImposterFunctionCall(CodeParser.ImposterFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#imposterFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitImposterFunctionCall(CodeParser.ImposterFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#functionArg}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArg(CodeParser.FunctionArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#functionArg}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArg(CodeParser.FunctionArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#anonFuncDef}.
	 * @param ctx the parse tree
	 */
	void enterAnonFuncDef(CodeParser.AnonFuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#anonFuncDef}.
	 * @param ctx the parse tree
	 */
	void exitAnonFuncDef(CodeParser.AnonFuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(CodeParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(CodeParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#functionAnnotations}.
	 * @param ctx the parse tree
	 */
	void enterFunctionAnnotations(CodeParser.FunctionAnnotationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#functionAnnotations}.
	 * @param ctx the parse tree
	 */
	void exitFunctionAnnotations(CodeParser.FunctionAnnotationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#functionParam}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParam(CodeParser.FunctionParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#functionParam}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParam(CodeParser.FunctionParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(CodeParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(CodeParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(CodeParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(CodeParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#generateExpression}.
	 * @param ctx the parse tree
	 */
	void enterGenerateExpression(CodeParser.GenerateExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#generateExpression}.
	 * @param ctx the parse tree
	 */
	void exitGenerateExpression(CodeParser.GenerateExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(CodeParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(CodeParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(CodeParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(CodeParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#anonIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterAnonIdentifier(CodeParser.AnonIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#anonIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitAnonIdentifier(CodeParser.AnonIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#thisLiteral}.
	 * @param ctx the parse tree
	 */
	void enterThisLiteral(CodeParser.ThisLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#thisLiteral}.
	 * @param ctx the parse tree
	 */
	void exitThisLiteral(CodeParser.ThisLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#parentLiteral}.
	 * @param ctx the parse tree
	 */
	void enterParentLiteral(CodeParser.ParentLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#parentLiteral}.
	 * @param ctx the parse tree
	 */
	void exitParentLiteral(CodeParser.ParentLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(CodeParser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#booleanLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(CodeParser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#nilLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNilLiteral(CodeParser.NilLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#nilLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNilLiteral(CodeParser.NilLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#accessor}.
	 * @param ctx the parse tree
	 */
	void enterAccessor(CodeParser.AccessorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#accessor}.
	 * @param ctx the parse tree
	 */
	void exitAccessor(CodeParser.AccessorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#spreadElement}.
	 * @param ctx the parse tree
	 */
	void enterSpreadElement(CodeParser.SpreadElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#spreadElement}.
	 * @param ctx the parse tree
	 */
	void exitSpreadElement(CodeParser.SpreadElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(CodeParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(CodeParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(CodeParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(CodeParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#assignmentExpr}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpr(CodeParser.AssignmentExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#assignmentExpr}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpr(CodeParser.AssignmentExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#assignmentPattern}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentPattern(CodeParser.AssignmentPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#assignmentPattern}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentPattern(CodeParser.AssignmentPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#bindingDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterBindingDeclaration(CodeParser.BindingDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#bindingDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitBindingDeclaration(CodeParser.BindingDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#arrayBindingDec}.
	 * @param ctx the parse tree
	 */
	void enterArrayBindingDec(CodeParser.ArrayBindingDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#arrayBindingDec}.
	 * @param ctx the parse tree
	 */
	void exitArrayBindingDec(CodeParser.ArrayBindingDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#objectBindingDec}.
	 * @param ctx the parse tree
	 */
	void enterObjectBindingDec(CodeParser.ObjectBindingDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#objectBindingDec}.
	 * @param ctx the parse tree
	 */
	void exitObjectBindingDec(CodeParser.ObjectBindingDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#bindingPattern}.
	 * @param ctx the parse tree
	 */
	void enterBindingPattern(CodeParser.BindingPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#bindingPattern}.
	 * @param ctx the parse tree
	 */
	void exitBindingPattern(CodeParser.BindingPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#arrayExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpression(CodeParser.ArrayExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#arrayExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpression(CodeParser.ArrayExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#arrayExpressionElement}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpressionElement(CodeParser.ArrayExpressionElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#arrayExpressionElement}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpressionElement(CodeParser.ArrayExpressionElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#arrayPattern}.
	 * @param ctx the parse tree
	 */
	void enterArrayPattern(CodeParser.ArrayPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#arrayPattern}.
	 * @param ctx the parse tree
	 */
	void exitArrayPattern(CodeParser.ArrayPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#arrayPatternElement}.
	 * @param ctx the parse tree
	 */
	void enterArrayPatternElement(CodeParser.ArrayPatternElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#arrayPatternElement}.
	 * @param ctx the parse tree
	 */
	void exitArrayPatternElement(CodeParser.ArrayPatternElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#objectExpression}.
	 * @param ctx the parse tree
	 */
	void enterObjectExpression(CodeParser.ObjectExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#objectExpression}.
	 * @param ctx the parse tree
	 */
	void exitObjectExpression(CodeParser.ObjectExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#objectExpressionElement}.
	 * @param ctx the parse tree
	 */
	void enterObjectExpressionElement(CodeParser.ObjectExpressionElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#objectExpressionElement}.
	 * @param ctx the parse tree
	 */
	void exitObjectExpressionElement(CodeParser.ObjectExpressionElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#objectPattern}.
	 * @param ctx the parse tree
	 */
	void enterObjectPattern(CodeParser.ObjectPatternContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#objectPattern}.
	 * @param ctx the parse tree
	 */
	void exitObjectPattern(CodeParser.ObjectPatternContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#objectPatternElement}.
	 * @param ctx the parse tree
	 */
	void enterObjectPatternElement(CodeParser.ObjectPatternElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#objectPatternElement}.
	 * @param ctx the parse tree
	 */
	void exitObjectPatternElement(CodeParser.ObjectPatternElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(CodeParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(CodeParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#binaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(CodeParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#binaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(CodeParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#logicExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpr(CodeParser.LogicExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#logicExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpr(CodeParser.LogicExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#ternaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpr(CodeParser.TernaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#ternaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpr(CodeParser.TernaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(CodeParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#newExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(CodeParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#waitforExpression}.
	 * @param ctx the parse tree
	 */
	void enterWaitforExpression(CodeParser.WaitforExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#waitforExpression}.
	 * @param ctx the parse tree
	 */
	void exitWaitforExpression(CodeParser.WaitforExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(CodeParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(CodeParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(CodeParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(CodeParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(CodeParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(CodeParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStatement(CodeParser.DoWhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStatement(CodeParser.DoWhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(CodeParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(CodeParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#forIndexedStatement}.
	 * @param ctx the parse tree
	 */
	void enterForIndexedStatement(CodeParser.ForIndexedStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#forIndexedStatement}.
	 * @param ctx the parse tree
	 */
	void exitForIndexedStatement(CodeParser.ForIndexedStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#forEachStatement}.
	 * @param ctx the parse tree
	 */
	void enterForEachStatement(CodeParser.ForEachStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#forEachStatement}.
	 * @param ctx the parse tree
	 */
	void exitForEachStatement(CodeParser.ForEachStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#skipStatement}.
	 * @param ctx the parse tree
	 */
	void enterSkipStatement(CodeParser.SkipStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#skipStatement}.
	 * @param ctx the parse tree
	 */
	void exitSkipStatement(CodeParser.SkipStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(CodeParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(CodeParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(CodeParser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(CodeParser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#guardStatement}.
	 * @param ctx the parse tree
	 */
	void enterGuardStatement(CodeParser.GuardStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#guardStatement}.
	 * @param ctx the parse tree
	 */
	void exitGuardStatement(CodeParser.GuardStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void enterFromClause(CodeParser.FromClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#fromClause}.
	 * @param ctx the parse tree
	 */
	void exitFromClause(CodeParser.FromClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#endwithClause}.
	 * @param ctx the parse tree
	 */
	void enterEndwithClause(CodeParser.EndwithClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#endwithClause}.
	 * @param ctx the parse tree
	 */
	void exitEndwithClause(CodeParser.EndwithClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#logicStatementTest}.
	 * @param ctx the parse tree
	 */
	void enterLogicStatementTest(CodeParser.LogicStatementTestContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#logicStatementTest}.
	 * @param ctx the parse tree
	 */
	void exitLogicStatementTest(CodeParser.LogicStatementTestContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#matchStatement}.
	 * @param ctx the parse tree
	 */
	void enterMatchStatement(CodeParser.MatchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#matchStatement}.
	 * @param ctx the parse tree
	 */
	void exitMatchStatement(CodeParser.MatchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#matchBody}.
	 * @param ctx the parse tree
	 */
	void enterMatchBody(CodeParser.MatchBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#matchBody}.
	 * @param ctx the parse tree
	 */
	void exitMatchBody(CodeParser.MatchBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FullMatchClause}
	 * labeled alternative in {@link CodeParser#matchClause}.
	 * @param ctx the parse tree
	 */
	void enterFullMatchClause(CodeParser.FullMatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FullMatchClause}
	 * labeled alternative in {@link CodeParser#matchClause}.
	 * @param ctx the parse tree
	 */
	void exitFullMatchClause(CodeParser.FullMatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ShortMatchClause}
	 * labeled alternative in {@link CodeParser#matchClause}.
	 * @param ctx the parse tree
	 */
	void enterShortMatchClause(CodeParser.ShortMatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ShortMatchClause}
	 * labeled alternative in {@link CodeParser#matchClause}.
	 * @param ctx the parse tree
	 */
	void exitShortMatchClause(CodeParser.ShortMatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#matchExpression}.
	 * @param ctx the parse tree
	 */
	void enterMatchExpression(CodeParser.MatchExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#matchExpression}.
	 * @param ctx the parse tree
	 */
	void exitMatchExpression(CodeParser.MatchExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#matchExpressionBody}.
	 * @param ctx the parse tree
	 */
	void enterMatchExpressionBody(CodeParser.MatchExpressionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#matchExpressionBody}.
	 * @param ctx the parse tree
	 */
	void exitMatchExpressionBody(CodeParser.MatchExpressionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#matchExpressionClause}.
	 * @param ctx the parse tree
	 */
	void enterMatchExpressionClause(CodeParser.MatchExpressionClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#matchExpressionClause}.
	 * @param ctx the parse tree
	 */
	void exitMatchExpressionClause(CodeParser.MatchExpressionClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#condStatement}.
	 * @param ctx the parse tree
	 */
	void enterCondStatement(CodeParser.CondStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#condStatement}.
	 * @param ctx the parse tree
	 */
	void exitCondStatement(CodeParser.CondStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#condBody}.
	 * @param ctx the parse tree
	 */
	void enterCondBody(CodeParser.CondBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#condBody}.
	 * @param ctx the parse tree
	 */
	void exitCondBody(CodeParser.CondBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#condClause}.
	 * @param ctx the parse tree
	 */
	void enterCondClause(CodeParser.CondClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#condClause}.
	 * @param ctx the parse tree
	 */
	void exitCondClause(CodeParser.CondClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#condExpression}.
	 * @param ctx the parse tree
	 */
	void enterCondExpression(CodeParser.CondExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#condExpression}.
	 * @param ctx the parse tree
	 */
	void exitCondExpression(CodeParser.CondExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#condExpressionBody}.
	 * @param ctx the parse tree
	 */
	void enterCondExpressionBody(CodeParser.CondExpressionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#condExpressionBody}.
	 * @param ctx the parse tree
	 */
	void exitCondExpressionBody(CodeParser.CondExpressionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#condExpressionClause}.
	 * @param ctx the parse tree
	 */
	void enterCondExpressionClause(CodeParser.CondExpressionClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#condExpressionClause}.
	 * @param ctx the parse tree
	 */
	void exitCondExpressionClause(CodeParser.CondExpressionClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(CodeParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(CodeParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#classParentDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassParentDeclaration(CodeParser.ClassParentDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#classParentDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassParentDeclaration(CodeParser.ClassParentDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(CodeParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(CodeParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodDef}
	 * labeled alternative in {@link CodeParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDef(CodeParser.MethodDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodDef}
	 * labeled alternative in {@link CodeParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDef(CodeParser.MethodDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CtorDef}
	 * labeled alternative in {@link CodeParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCtorDef(CodeParser.CtorDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CtorDef}
	 * labeled alternative in {@link CodeParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCtorDef(CodeParser.CtorDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#methodAnnotations}.
	 * @param ctx the parse tree
	 */
	void enterMethodAnnotations(CodeParser.MethodAnnotationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#methodAnnotations}.
	 * @param ctx the parse tree
	 */
	void exitMethodAnnotations(CodeParser.MethodAnnotationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(CodeParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(CodeParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(CodeParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(CodeParser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefaultImport}
	 * labeled alternative in {@link CodeParser#importSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterDefaultImport(CodeParser.DefaultImportContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefaultImport}
	 * labeled alternative in {@link CodeParser#importSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitDefaultImport(CodeParser.DefaultImportContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AllImport}
	 * labeled alternative in {@link CodeParser#importSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterAllImport(CodeParser.AllImportContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AllImport}
	 * labeled alternative in {@link CodeParser#importSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitAllImport(CodeParser.AllImportContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SpecificImport}
	 * labeled alternative in {@link CodeParser#importSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterSpecificImport(CodeParser.SpecificImportContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SpecificImport}
	 * labeled alternative in {@link CodeParser#importSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitSpecificImport(CodeParser.SpecificImportContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#exportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExportDeclaration(CodeParser.ExportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#exportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExportDeclaration(CodeParser.ExportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#exportAllDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExportAllDeclaration(CodeParser.ExportAllDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#exportAllDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExportAllDeclaration(CodeParser.ExportAllDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#exportDefaultDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExportDefaultDeclaration(CodeParser.ExportDefaultDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#exportDefaultDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExportDefaultDeclaration(CodeParser.ExportDefaultDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#exportNamedDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExportNamedDeclaration(CodeParser.ExportNamedDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#exportNamedDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExportNamedDeclaration(CodeParser.ExportNamedDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#exportSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterExportSpecifier(CodeParser.ExportSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#exportSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitExportSpecifier(CodeParser.ExportSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CodeParser#exportNamedDeclarationSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterExportNamedDeclarationSpecifier(CodeParser.ExportNamedDeclarationSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#exportNamedDeclarationSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitExportNamedDeclarationSpecifier(CodeParser.ExportNamedDeclarationSpecifierContext ctx);
}
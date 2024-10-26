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
	 * Enter a parse tree produced by {@link CodeParser#functionParamAssign}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParamAssign(CodeParser.FunctionParamAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link CodeParser#functionParamAssign}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParamAssign(CodeParser.FunctionParamAssignContext ctx);
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
}
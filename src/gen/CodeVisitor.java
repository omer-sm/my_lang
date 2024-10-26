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
	 * Visit a parse tree produced by {@link CodeParser#anonFuncDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonFuncDef(CodeParser.AnonFuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#functionArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArg(CodeParser.FunctionArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#spreadElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpreadElement(CodeParser.SpreadElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CodeParser.BlockContext ctx);
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
	 * Visit a parse tree produced by {@link CodeParser#ternaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpr(CodeParser.TernaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#accessor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessor(CodeParser.AccessorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#assignmentExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpr(CodeParser.AssignmentExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(CodeParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CodeParser#nestedStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedStatement(CodeParser.NestedStatementContext ctx);
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
	 * Visit a parse tree produced by {@link CodeParser#functionParamAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParamAssign(CodeParser.FunctionParamAssignContext ctx);
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
}
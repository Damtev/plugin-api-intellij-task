// Generated from org/jetbrains/array/operations/ArrayOperationsGrammar.g4 by ANTLR 4.8

package org.jetbrains.array.operations;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArrayOperationsGrammarParser}.
 */
public interface ArrayOperationsGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ArrayOperationsGrammarParser#call_chain}.
	 * @param ctx the parse tree
	 */
	void enterCall_chain(ArrayOperationsGrammarParser.Call_chainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayOperationsGrammarParser#call_chain}.
	 * @param ctx the parse tree
	 */
	void exitCall_chain(ArrayOperationsGrammarParser.Call_chainContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayOperationsGrammarParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(ArrayOperationsGrammarParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayOperationsGrammarParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(ArrayOperationsGrammarParser.CallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayOperationsGrammarParser#map_call}.
	 * @param ctx the parse tree
	 */
	void enterMap_call(ArrayOperationsGrammarParser.Map_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayOperationsGrammarParser#map_call}.
	 * @param ctx the parse tree
	 */
	void exitMap_call(ArrayOperationsGrammarParser.Map_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayOperationsGrammarParser#filter_call}.
	 * @param ctx the parse tree
	 */
	void enterFilter_call(ArrayOperationsGrammarParser.Filter_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayOperationsGrammarParser#filter_call}.
	 * @param ctx the parse tree
	 */
	void exitFilter_call(ArrayOperationsGrammarParser.Filter_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayOperationsGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ArrayOperationsGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayOperationsGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ArrayOperationsGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayOperationsGrammarParser#binary_expr}.
	 * @param ctx the parse tree
	 */
	void enterBinary_expr(ArrayOperationsGrammarParser.Binary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayOperationsGrammarParser#binary_expr}.
	 * @param ctx the parse tree
	 */
	void exitBinary_expr(ArrayOperationsGrammarParser.Binary_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ArrayOperationsGrammarParser#binary_operation}.
	 * @param ctx the parse tree
	 */
	void enterBinary_operation(ArrayOperationsGrammarParser.Binary_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ArrayOperationsGrammarParser#binary_operation}.
	 * @param ctx the parse tree
	 */
	void exitBinary_operation(ArrayOperationsGrammarParser.Binary_operationContext ctx);
}
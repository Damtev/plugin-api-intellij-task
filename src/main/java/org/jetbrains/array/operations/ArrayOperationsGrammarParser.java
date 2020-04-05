// Generated from org/jetbrains/array/operations/ArrayOperationsGrammar.g4 by ANTLR 4.8

package org.jetbrains.array.operations;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ArrayOperationsGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBER=1, DIGIT=2, WHITESPACE=3, LEFT_BR=4, RIGHT_BR=5, LEFT_CURLY=6, 
		RIGHT_CURLY=7, NEXT=8, MAP=9, FILTER=10, ELEMENT=11, PLUS=12, MINUS=13, 
		MULT=14, GREATER=15, LESS=16, EQUALS=17, AND=18, OR=19;
	public static final int
		RULE_call_chain = 0, RULE_call = 1, RULE_map_call = 2, RULE_filter_call = 3, 
		RULE_expr = 4, RULE_binary_expr = 5, RULE_binary_operation = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"call_chain", "call", "map_call", "filter_call", "expr", "binary_expr", 
			"binary_operation"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "' '", "'('", "')'", "'{'", "'}'", "'%>%'", "'map'", 
			"'filter'", "'element'", "'+'", "'-'", "'*'", "'>'", "'<'", "'='", "'&'", 
			"'|'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NUMBER", "DIGIT", "WHITESPACE", "LEFT_BR", "RIGHT_BR", "LEFT_CURLY", 
			"RIGHT_CURLY", "NEXT", "MAP", "FILTER", "ELEMENT", "PLUS", "MINUS", "MULT", 
			"GREATER", "LESS", "EQUALS", "AND", "OR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ArrayOperationsGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ArrayOperationsGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Call_chainContext extends ParserRuleContext {
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public TerminalNode NEXT() { return getToken(ArrayOperationsGrammarParser.NEXT, 0); }
		public Call_chainContext call_chain() {
			return getRuleContext(Call_chainContext.class,0);
		}
		public Call_chainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_chain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayOperationsGrammarListener ) ((ArrayOperationsGrammarListener)listener).enterCall_chain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayOperationsGrammarListener ) ((ArrayOperationsGrammarListener)listener).exitCall_chain(this);
		}
	}

	public final Call_chainContext call_chain() throws RecognitionException {
		Call_chainContext _localctx = new Call_chainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_call_chain);
		try {
			setState(19);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(15);
				call();
				setState(16);
				match(NEXT);
				setState(17);
				call_chain();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallContext extends ParserRuleContext {
		public Map_callContext map_call() {
			return getRuleContext(Map_callContext.class,0);
		}
		public Filter_callContext filter_call() {
			return getRuleContext(Filter_callContext.class,0);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayOperationsGrammarListener ) ((ArrayOperationsGrammarListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayOperationsGrammarListener ) ((ArrayOperationsGrammarListener)listener).exitCall(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_call);
		try {
			setState(23);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MAP:
				enterOuterAlt(_localctx, 1);
				{
				setState(21);
				map_call();
				}
				break;
			case FILTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				filter_call();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Map_callContext extends ParserRuleContext {
		public TerminalNode MAP() { return getToken(ArrayOperationsGrammarParser.MAP, 0); }
		public TerminalNode LEFT_CURLY() { return getToken(ArrayOperationsGrammarParser.LEFT_CURLY, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_CURLY() { return getToken(ArrayOperationsGrammarParser.RIGHT_CURLY, 0); }
		public Map_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_map_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayOperationsGrammarListener ) ((ArrayOperationsGrammarListener)listener).enterMap_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayOperationsGrammarListener ) ((ArrayOperationsGrammarListener)listener).exitMap_call(this);
		}
	}

	public final Map_callContext map_call() throws RecognitionException {
		Map_callContext _localctx = new Map_callContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_map_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(MAP);
			setState(26);
			match(LEFT_CURLY);
			setState(27);
			expr();
			setState(28);
			match(RIGHT_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Filter_callContext extends ParserRuleContext {
		public TerminalNode FILTER() { return getToken(ArrayOperationsGrammarParser.FILTER, 0); }
		public TerminalNode LEFT_CURLY() { return getToken(ArrayOperationsGrammarParser.LEFT_CURLY, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_CURLY() { return getToken(ArrayOperationsGrammarParser.RIGHT_CURLY, 0); }
		public Filter_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filter_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayOperationsGrammarListener ) ((ArrayOperationsGrammarListener)listener).enterFilter_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayOperationsGrammarListener ) ((ArrayOperationsGrammarListener)listener).exitFilter_call(this);
		}
	}

	public final Filter_callContext filter_call() throws RecognitionException {
		Filter_callContext _localctx = new Filter_callContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_filter_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(FILTER);
			setState(31);
			match(LEFT_CURLY);
			setState(32);
			expr();
			setState(33);
			match(RIGHT_CURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode ELEMENT() { return getToken(ArrayOperationsGrammarParser.ELEMENT, 0); }
		public TerminalNode NUMBER() { return getToken(ArrayOperationsGrammarParser.NUMBER, 0); }
		public Binary_exprContext binary_expr() {
			return getRuleContext(Binary_exprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayOperationsGrammarListener ) ((ArrayOperationsGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayOperationsGrammarListener ) ((ArrayOperationsGrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expr);
		try {
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELEMENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				match(ELEMENT);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				match(NUMBER);
				}
				break;
			case LEFT_BR:
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				binary_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_exprContext extends ParserRuleContext {
		public TerminalNode LEFT_BR() { return getToken(ArrayOperationsGrammarParser.LEFT_BR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> WHITESPACE() { return getTokens(ArrayOperationsGrammarParser.WHITESPACE); }
		public TerminalNode WHITESPACE(int i) {
			return getToken(ArrayOperationsGrammarParser.WHITESPACE, i);
		}
		public Binary_operationContext binary_operation() {
			return getRuleContext(Binary_operationContext.class,0);
		}
		public TerminalNode RIGHT_BR() { return getToken(ArrayOperationsGrammarParser.RIGHT_BR, 0); }
		public Binary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayOperationsGrammarListener ) ((ArrayOperationsGrammarListener)listener).enterBinary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayOperationsGrammarListener ) ((ArrayOperationsGrammarListener)listener).exitBinary_expr(this);
		}
	}

	public final Binary_exprContext binary_expr() throws RecognitionException {
		Binary_exprContext _localctx = new Binary_exprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_binary_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(LEFT_BR);
			setState(41);
			expr();
			setState(42);
			match(WHITESPACE);
			setState(43);
			binary_operation();
			setState(44);
			match(WHITESPACE);
			setState(45);
			expr();
			setState(46);
			match(RIGHT_BR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_operationContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(ArrayOperationsGrammarParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ArrayOperationsGrammarParser.MINUS, 0); }
		public TerminalNode MULT() { return getToken(ArrayOperationsGrammarParser.MULT, 0); }
		public TerminalNode GREATER() { return getToken(ArrayOperationsGrammarParser.GREATER, 0); }
		public TerminalNode LESS() { return getToken(ArrayOperationsGrammarParser.LESS, 0); }
		public TerminalNode EQUALS() { return getToken(ArrayOperationsGrammarParser.EQUALS, 0); }
		public TerminalNode AND() { return getToken(ArrayOperationsGrammarParser.AND, 0); }
		public TerminalNode OR() { return getToken(ArrayOperationsGrammarParser.OR, 0); }
		public Binary_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayOperationsGrammarListener ) ((ArrayOperationsGrammarListener)listener).enterBinary_operation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ArrayOperationsGrammarListener ) ((ArrayOperationsGrammarListener)listener).exitBinary_operation(this);
		}
	}

	public final Binary_operationContext binary_operation() throws RecognitionException {
		Binary_operationContext _localctx = new Binary_operationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_binary_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << MULT) | (1L << GREATER) | (1L << LESS) | (1L << EQUALS) | (1L << AND) | (1L << OR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25\65\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\5\2\26"+
		"\n\2\3\3\3\3\5\3\32\n\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\5\6)\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\2\2\t\2\4"+
		"\6\b\n\f\16\2\3\3\2\16\25\2\61\2\25\3\2\2\2\4\31\3\2\2\2\6\33\3\2\2\2"+
		"\b \3\2\2\2\n(\3\2\2\2\f*\3\2\2\2\16\62\3\2\2\2\20\26\5\4\3\2\21\22\5"+
		"\4\3\2\22\23\7\n\2\2\23\24\5\2\2\2\24\26\3\2\2\2\25\20\3\2\2\2\25\21\3"+
		"\2\2\2\26\3\3\2\2\2\27\32\5\6\4\2\30\32\5\b\5\2\31\27\3\2\2\2\31\30\3"+
		"\2\2\2\32\5\3\2\2\2\33\34\7\13\2\2\34\35\7\b\2\2\35\36\5\n\6\2\36\37\7"+
		"\t\2\2\37\7\3\2\2\2 !\7\f\2\2!\"\7\b\2\2\"#\5\n\6\2#$\7\t\2\2$\t\3\2\2"+
		"\2%)\7\r\2\2&)\7\3\2\2\')\5\f\7\2(%\3\2\2\2(&\3\2\2\2(\'\3\2\2\2)\13\3"+
		"\2\2\2*+\7\6\2\2+,\5\n\6\2,-\7\5\2\2-.\5\16\b\2./\7\5\2\2/\60\5\n\6\2"+
		"\60\61\7\7\2\2\61\r\3\2\2\2\62\63\t\2\2\2\63\17\3\2\2\2\5\25\31(";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
// Generated from org/jetbrains/array/operations/ArrayOperationsGrammar.g4 by ANTLR 4.8

package org.jetbrains.array.operations;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ArrayOperationsGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBER=1, DIGIT=2, WHITESPACE=3, LEFT_BR=4, RIGHT_BR=5, LEFT_CURLY=6, 
		RIGHT_CURLY=7, NEXT=8, MAP=9, FILTER=10, ELEMENT=11, PLUS=12, MINUS=13, 
		MULT=14, GREATER=15, LESS=16, EQUALS=17, AND=18, OR=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NUMBER", "DIGIT", "WHITESPACE", "LEFT_BR", "RIGHT_BR", "LEFT_CURLY", 
			"RIGHT_CURLY", "NEXT", "MAP", "FILTER", "ELEMENT", "PLUS", "MINUS", "MULT", 
			"GREATER", "LESS", "EQUALS", "AND", "OR"
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


	public ArrayOperationsGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ArrayOperationsGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25i\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\5\2,\n\2\3\2\3\2\7\2\60\n\2\f\2\16\2\63\13"+
		"\2\5\2\65\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\4\3\2"+
		"\63;\3\2\62;\2k\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3\64\3\2\2\2\5\66\3\2\2\2\78"+
		"\3\2\2\2\t:\3\2\2\2\13<\3\2\2\2\r>\3\2\2\2\17@\3\2\2\2\21B\3\2\2\2\23"+
		"F\3\2\2\2\25J\3\2\2\2\27Q\3\2\2\2\31Y\3\2\2\2\33[\3\2\2\2\35]\3\2\2\2"+
		"\37_\3\2\2\2!a\3\2\2\2#c\3\2\2\2%e\3\2\2\2\'g\3\2\2\2)\65\7\62\2\2*,\7"+
		"/\2\2+*\3\2\2\2+,\3\2\2\2,-\3\2\2\2-\61\t\2\2\2.\60\5\5\3\2/.\3\2\2\2"+
		"\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\64"+
		")\3\2\2\2\64+\3\2\2\2\65\4\3\2\2\2\66\67\t\3\2\2\67\6\3\2\2\289\7\"\2"+
		"\29\b\3\2\2\2:;\7*\2\2;\n\3\2\2\2<=\7+\2\2=\f\3\2\2\2>?\7}\2\2?\16\3\2"+
		"\2\2@A\7\177\2\2A\20\3\2\2\2BC\7\'\2\2CD\7@\2\2DE\7\'\2\2E\22\3\2\2\2"+
		"FG\7o\2\2GH\7c\2\2HI\7r\2\2I\24\3\2\2\2JK\7h\2\2KL\7k\2\2LM\7n\2\2MN\7"+
		"v\2\2NO\7g\2\2OP\7t\2\2P\26\3\2\2\2QR\7g\2\2RS\7n\2\2ST\7g\2\2TU\7o\2"+
		"\2UV\7g\2\2VW\7p\2\2WX\7v\2\2X\30\3\2\2\2YZ\7-\2\2Z\32\3\2\2\2[\\\7/\2"+
		"\2\\\34\3\2\2\2]^\7,\2\2^\36\3\2\2\2_`\7@\2\2` \3\2\2\2ab\7>\2\2b\"\3"+
		"\2\2\2cd\7?\2\2d$\3\2\2\2ef\7(\2\2f&\3\2\2\2gh\7~\2\2h(\3\2\2\2\6\2+\61"+
		"\64\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
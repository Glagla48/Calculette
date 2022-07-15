// Generated from d:\hueri\Documents\LicenceInfo\l3\cours\th�orie des langues et compilation\calculette-tlc\src\Calculette.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalculetteParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		COMMENT=32, RETURN=33, TYPE=34, IDENTIFIANT=35, NEWLINE=36, WS=37, ENTIER=38, 
		UNMATCH=39;
	public static final int
		RULE_start = 0, RULE_calcul = 1, RULE_decl = 2, RULE_instruction = 3, 
		RULE_instructionthen = 4, RULE_instructionelse = 5, RULE_bloc = 6, RULE_assignation = 7, 
		RULE_finInstruction = 8, RULE_fonction = 9, RULE_params = 10, RULE_args = 11, 
		RULE_expr = 12, RULE_condition = 13;
	public static final String[] ruleNames = {
		"start", "calcul", "decl", "instruction", "instructionthen", "instructionelse", 
		"bloc", "assignation", "finInstruction", "fonction", "params", "args", 
		"expr", "condition"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'write'", "'('", "')'", "'read'", "'while'", "'if'", "'else'", 
		"'for'", "';'", "'repeat'", "'until'", "'{'", "'}'", "','", "'*'", "'/'", 
		"'+'", "'-'", "'<'", "'<='", "'=='", "'!='", "'>'", "'>='", "'<>'", "'&&'", 
		"'||'", "'!'", "'true'", "'false'", null, "'return'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "COMMENT", "RETURN", "TYPE", 
		"IDENTIFIANT", "NEWLINE", "WS", "ENTIER", "UNMATCH"
	};
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
	public String getGrammarFileName() { return "Calculette.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    //private TableSymboles tableSymboles =  new TableSymboles();

	    private TablesSymboles tablesSymboles =  new TablesSymboles();

	    private int _cur_label = 0;

	    private int nextLabel() {
	        return _cur_label++;
	    }

	    private String evalexpr (String x, String op, String y) {
	        if ( op.equals("*") ){
	            return x+y+"MUL\n";
	        } else if ( op.equals("+") ){
	            return x+y+"ADD\n";
	        } else if ( op.equals("/") ){
	            if(y == "0")
	            {
	              System.err.println("Impossible de diviser par 0");
	              throw new IllegalArgumentException("Impossible de diviser par 0");
	            }
	            return x+y+"DIV \n";
	        } else if ( op.equals("-") ){
	            return x+y+"SUB \n";
	        }
	         else if(op.equals("<"))
	        {
	            return x + y + "INF \n";
	        }
	        else if(op.equals("<="))
	        {
	            return x + y + "INFEQ\n";
	        }
	        else if(op.equals("=="))
	        {
	            return x + y + "EQUAL\n";
	        }
	        else if(op.equals("!=") || op.equals("<>"))
	        {
	            return x + y + "NEQ\n";
	        }
	        else if(op.equals(">"))
	        {
	            return x + y + "SUP\n";
	        }
	        else if(op.equals(">="))
	        {
	            return x + y + "SUPEQ \n";
	        }else {
	           System.err.println("Opérateur arithmétique incorrect : '"+op+"'");
	           throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
	        }
	    }

	    //pushOrStoreInFunction
	    private String posif(String pushOrStore, int adr)
	    {
	        if(pushOrStore.equals("push"))
	        {
	            if(adr < 0)
	                return "PUSHL ";
	            else
	                return "PUSHG ";
	        }
	        else
	        {
	            if(adr < 0)
	                return "STOREL ";
	            else
	                return "STOREG ";
	        }
	    }


	public CalculetteParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public CalculContext calcul() {
			return getRuleContext(CalculContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CalculetteParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			calcul();
			setState(29);
			match(EOF);
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

	public static class CalculContext extends ParserRuleContext {
		public String code;
		public DeclContext decl;
		public FonctionContext fonction;
		public InstructionContext instruction;
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public List<FonctionContext> fonction() {
			return getRuleContexts(FonctionContext.class);
		}
		public FonctionContext fonction(int i) {
			return getRuleContext(FonctionContext.class,i);
		}
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public CalculContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calcul; }
	}

	public final CalculContext calcul() throws RecognitionException {
		CalculContext _localctx = new CalculContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_calcul);
		 ((CalculContext)_localctx).code =  new String(); 
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(31);
					((CalculContext)_localctx).decl = decl();
					 _localctx.code += ((CalculContext)_localctx).decl.code; 
					}
					} 
				}
				setState(38);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			 int entry = nextLabel(); _localctx.code += "  JUMP " + entry + "\n"; 
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(40);
					match(NEWLINE);
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(46);
				((CalculContext)_localctx).fonction = fonction();
				 _localctx.code += ((CalculContext)_localctx).fonction.code; 
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(54);
					match(NEWLINE);
					}
					} 
				}
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			 _localctx.code += "LABEL " + entry + "\n"; 
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__18) | (1L << RETURN) | (1L << IDENTIFIANT) | (1L << NEWLINE) | (1L << ENTIER))) != 0)) {
				{
				{
				setState(61);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 _localctx.code += "  HALT\n"; 
			}
			_ctx.stop = _input.LT(-1);
			 System.out.println(_localctx.code); 
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

	public static class DeclContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public ExprContext expr;
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(72);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(73);
				finInstruction();

				          tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null), (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
				         
				          ((DeclContext)_localctx).code =  "PUSHI 0\n";
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(77);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(78);
				match(T__0);
				setState(79);
				((DeclContext)_localctx).expr = expr(0);
				setState(80);
				finInstruction();

				        tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null), (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
				        int adr = tablesSymboles.getAdresseType((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null)).adresse;
				        String store = posif("store", adr);
				        ((DeclContext)_localctx).code = "PUSHI 0\n";

				        _localctx.code += ((DeclContext)_localctx).expr.code + "\n" + store + adr + "\n";
				    
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

	public static class InstructionContext extends ParserRuleContext {
		public String code;
		public ExprContext expr;
		public AssignationContext assignation;
		public Token IDENTIFIANT;
		public ConditionContext condition;
		public BlocContext bloc;
		public InstructionContext instruction;
		public InstructionthenContext instructionthen;
		public InstructionelseContext instructionelse;
		public AssignationContext a1;
		public AssignationContext a2;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FinInstructionContext finInstruction() {
			return getRuleContext(FinInstructionContext.class,0);
		}
		public List<AssignationContext> assignation() {
			return getRuleContexts(AssignationContext.class);
		}
		public AssignationContext assignation(int i) {
			return getRuleContext(AssignationContext.class,i);
		}
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public InstructionthenContext instructionthen() {
			return getRuleContext(InstructionthenContext.class,0);
		}
		public InstructionelseContext instructionelse() {
			return getRuleContext(InstructionelseContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(CalculetteParser.RETURN, 0); }
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruction);
		int _la;
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				((InstructionContext)_localctx).expr = expr(0);
				setState(86);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expr.code;
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				((InstructionContext)_localctx).assignation = assignation();
				setState(90);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code;
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				finInstruction();

				            ((InstructionContext)_localctx).code = "";
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				match(T__1);
				setState(97);
				match(T__2);
				setState(98);
				((InstructionContext)_localctx).expr = expr(0);
				setState(99);
				match(T__3);
				setState(100);
				finInstruction();

				        ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expr.code + "WRITE\nPOP\n";
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(103);
				match(T__4);
				setState(104);
				match(T__2);
				setState(105);
				((InstructionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(106);
				match(T__3);
				setState(107);
				finInstruction();

				        int adr = tablesSymboles.getAdresseType((((InstructionContext)_localctx).IDENTIFIANT!=null?((InstructionContext)_localctx).IDENTIFIANT.getText():null)).adresse;
				        String store = posif("store", adr);
				        ((InstructionContext)_localctx).code =  "READ\n" + store + adr + "\n";
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(110);
				match(T__5);
				setState(111);
				match(T__2);
				setState(112);
				((InstructionContext)_localctx).condition = condition(0);
				setState(113);
				match(T__3);
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(114);
					match(NEWLINE);
					}
				}

				setState(117);
				((InstructionContext)_localctx).bloc = bloc();

				        int labelA = nextLabel();
				        int labelB = nextLabel();
				        ((InstructionContext)_localctx).code =  "LABEL " + labelA + "\n" + ((InstructionContext)_localctx).condition.code + "JUMPF " + labelB + "\n" + ((InstructionContext)_localctx).bloc.code + "JUMP " + labelA + "\n" +"LABEL " + labelB + "\n";
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(120);
				match(T__5);
				setState(121);
				match(T__2);
				setState(122);
				((InstructionContext)_localctx).condition = condition(0);
				setState(123);
				match(T__3);
				setState(124);
				((InstructionContext)_localctx).instruction = instruction();

				        int labelA = nextLabel();
				        int labelB = nextLabel();
				        ((InstructionContext)_localctx).code =  "LABEL " + labelA + "\n" + ((InstructionContext)_localctx).condition.code + "JUMPF " + labelB + "\n" + ((InstructionContext)_localctx).instruction.code + "JUMP " + labelA + "\n" + "LABEL " + labelB + "\n";
				    
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(127);
				match(T__6);
				setState(128);
				match(T__2);
				setState(129);
				((InstructionContext)_localctx).condition = condition(0);
				setState(130);
				match(T__3);
				setState(132);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(131);
					match(NEWLINE);
					}
					break;
				}
				setState(134);
				((InstructionContext)_localctx).instructionthen = instructionthen();
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(135);
					match(NEWLINE);
					}
				}

				setState(138);
				match(T__7);
				setState(139);
				((InstructionContext)_localctx).instructionelse = instructionelse();

				      int l1 = nextLabel();
				      int l2 = nextLabel();
				      ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).condition.code + "JUMPF " + l1 + "\n" + ((InstructionContext)_localctx).instructionthen.code + "JUMP " + l2 + "\n"
				      + "LABEL " + l1 + "\n" + ((InstructionContext)_localctx).instructionelse.code + "LABEL " + l2 + "\n";
				    
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(142);
				match(T__6);
				setState(143);
				match(T__2);
				setState(144);
				((InstructionContext)_localctx).condition = condition(0);
				setState(145);
				match(T__3);
				setState(147);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(146);
					match(NEWLINE);
					}
					break;
				}
				setState(149);
				((InstructionContext)_localctx).instructionthen = instructionthen();

				      int l1 = nextLabel();
				      ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).condition.code + "JUMPF " + l1 + "\n" + ((InstructionContext)_localctx).instructionthen.code + "LABEL " + l1 + "\n";
				    
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(152);
				match(T__8);
				setState(153);
				match(T__2);
				setState(154);
				((InstructionContext)_localctx).a1 = assignation();
				setState(155);
				match(T__9);
				setState(156);
				((InstructionContext)_localctx).condition = condition(0);
				setState(157);
				match(T__9);
				setState(158);
				((InstructionContext)_localctx).a2 = assignation();
				setState(159);
				match(T__3);
				setState(161);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(160);
					match(NEWLINE);
					}
					break;
				}
				setState(163);
				((InstructionContext)_localctx).instructionthen = instructionthen();

				      int l1 = nextLabel();
				      int l2 = nextLabel();
				      ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).a1.code + "LABEL " + l1 + "\n" + ((InstructionContext)_localctx).condition.code + "JUMPF " + l2
				      + "\n"  + ((InstructionContext)_localctx).instructionthen.code + ((InstructionContext)_localctx).a2.code + "JUMP " + l1 +"\n"+ "LABEL " + l2 + "\n";
				    
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(166);
				match(T__10);
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(167);
					match(NEWLINE);
					}
				}

				setState(170);
				((InstructionContext)_localctx).bloc = bloc();
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(171);
					match(NEWLINE);
					}
				}

				setState(174);
				match(T__11);
				setState(175);
				match(T__2);
				setState(176);
				((InstructionContext)_localctx).condition = condition(0);
				setState(177);
				match(T__3);

				        int labelA = nextLabel();
				        ((InstructionContext)_localctx).code =  "LABEL " + labelA + "\n" +
				            ((InstructionContext)_localctx).bloc.code +
				            ((InstructionContext)_localctx).condition.code +
				            "JUMPF " + labelA + "\n";
				    
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(180);
				match(RETURN);
				setState(181);
				((InstructionContext)_localctx).expr = expr(0);
				setState(182);
				finInstruction();

				        int adr = tablesSymboles.getAdresseType("return").adresse;
				        ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expr.code + "STOREL "+ adr + "\n"; 
				        _localctx.code += "RETURN\n";
				    
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

	public static class InstructionthenContext extends ParserRuleContext {
		public String code;
		public InstructionContext instruction;
		public BlocContext bloc;
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public InstructionthenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructionthen; }
	}

	public final InstructionthenContext instructionthen() throws RecognitionException {
		InstructionthenContext _localctx = new InstructionthenContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_instructionthen);
		try {
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__2:
			case T__4:
			case T__5:
			case T__6:
			case T__8:
			case T__9:
			case T__10:
			case T__18:
			case RETURN:
			case IDENTIFIANT:
			case NEWLINE:
			case ENTIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				((InstructionthenContext)_localctx).instruction = instruction();
				((InstructionthenContext)_localctx).code =  ((InstructionthenContext)_localctx).instruction.code;
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				((InstructionthenContext)_localctx).bloc = bloc();
				((InstructionthenContext)_localctx).code =  ((InstructionthenContext)_localctx).bloc.code;
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

	public static class InstructionelseContext extends ParserRuleContext {
		public String code;
		public ConditionContext condition;
		public InstructionthenContext instructionthen;
		public BlocContext bloc;
		public InstructionContext instruction;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public InstructionthenContext instructionthen() {
			return getRuleContext(InstructionthenContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(CalculetteParser.NEWLINE, 0); }
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public InstructionelseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructionelse; }
	}

	public final InstructionelseContext instructionelse() throws RecognitionException {
		InstructionelseContext _localctx = new InstructionelseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_instructionelse);
		int _la;
		try {
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				match(T__6);
				setState(196);
				match(T__2);
				setState(197);
				((InstructionelseContext)_localctx).condition = condition(0);
				setState(198);
				match(T__3);
				setState(200);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(199);
					match(NEWLINE);
					}
					break;
				}
				setState(202);
				((InstructionelseContext)_localctx).instructionthen = instructionthen();

				        ((InstructionelseContext)_localctx).code =  ((InstructionelseContext)_localctx).condition.code + "JUMPF " + nextLabel() + "\n" + ((InstructionelseContext)_localctx).instructionthen.code + "LABEL " + _cur_label + "\n";
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(205);
					match(NEWLINE);
					}
				}

				setState(208);
				((InstructionelseContext)_localctx).bloc = bloc();

				        ((InstructionelseContext)_localctx).code =  ((InstructionelseContext)_localctx).bloc.code;
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(212);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(211);
					match(NEWLINE);
					}
					break;
				}
				setState(214);
				((InstructionelseContext)_localctx).instruction = instruction();

				        ((InstructionelseContext)_localctx).code =  ((InstructionelseContext)_localctx).instruction.code;
				    
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

	public static class BlocContext extends ParserRuleContext {
		public String code;
		public InstructionContext instruction;
		public List<InstructionContext> instruction() {
			return getRuleContexts(InstructionContext.class);
		}
		public InstructionContext instruction(int i) {
			return getRuleContext(InstructionContext.class,i);
		}
		public BlocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloc; }
	}

	public final BlocContext bloc() throws RecognitionException {
		BlocContext _localctx = new BlocContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bloc);
		((BlocContext)_localctx).code =  new String();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(T__12);
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__18) | (1L << RETURN) | (1L << IDENTIFIANT) | (1L << NEWLINE) | (1L << ENTIER))) != 0)) {
				{
				{
				setState(220);
				((BlocContext)_localctx).instruction = instruction();
				_localctx.code += ((BlocContext)_localctx).instruction.code;
				}
				}
				setState(227);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(228);
			match(T__13);
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

	public static class AssignationContext extends ParserRuleContext {
		public String code;
		public Token IDENTIFIANT;
		public ExprContext expr;
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignation; }
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(231);
			match(T__0);
			setState(232);
			((AssignationContext)_localctx).expr = expr(0);

			            int adr = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null)).adresse;
			            String store = posif("store", adr);
			            ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expr.code + store + adr +"\n";
			        
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

	public static class FinInstructionContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(CalculetteParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(CalculetteParser.NEWLINE, i);
		}
		public FinInstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finInstruction; }
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(236); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(235);
					_la = _input.LA(1);
					if ( !(_la==T__9 || _la==NEWLINE) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(238); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class FonctionContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public ParamsContext params;
		public BlocContext bloc;
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public BlocContext bloc() {
			return getRuleContext(BlocContext.class,0);
		}
		public FonctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fonction; }
	}

	public final FonctionContext fonction() throws RecognitionException {
		FonctionContext _localctx = new FonctionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_fonction);
		tablesSymboles.newTableLocale();
		try {
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				((FonctionContext)_localctx).TYPE = match(TYPE);
				setState(241);
				((FonctionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				tablesSymboles.putVar("return", (((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
				setState(243);
				match(T__2);
				setState(244);
				((FonctionContext)_localctx).params = params();
				setState(245);
				match(T__3);

				            int l = nextLabel();   
				            tablesSymboles.newFunction((((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null), l, (((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
				            ((FonctionContext)_localctx).code =  "LABEL "+ l + "\n";
				            _localctx.code += ((FonctionContext)_localctx).params.code;
				            // truc à faire par rapport au code += "LABEL " + entry + "\n"; }

				        
				setState(247);
				((FonctionContext)_localctx).bloc = bloc();

				            _localctx.code += ((FonctionContext)_localctx).bloc.code;
				            _localctx.code += "RETURN\n";
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				((FonctionContext)_localctx).TYPE = match(TYPE);
				setState(251);
				((FonctionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				tablesSymboles.putVar("return", (((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
				setState(253);
				match(T__2);
				setState(254);
				match(T__3);

				            int l = nextLabel();   
				            tablesSymboles.newFunction((((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null), l, (((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
				            ((FonctionContext)_localctx).code =  "LABEL "+ l + "\n";
				            // truc à faire par rapport au code += "LABEL " + entry + "\n"; }

				        
				setState(256);
				((FonctionContext)_localctx).bloc = bloc();

				            _localctx.code += ((FonctionContext)_localctx).bloc.code;
				            _localctx.code += "RETURN\n";
				        
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			tablesSymboles.dropTableLocale();
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

	public static class ParamsContext extends ParserRuleContext {
		public String code;
		public Token TYPE;
		public Token IDENTIFIANT;
		public List<TerminalNode> TYPE() { return getTokens(CalculetteParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CalculetteParser.TYPE, i);
		}
		public List<TerminalNode> IDENTIFIANT() { return getTokens(CalculetteParser.IDENTIFIANT); }
		public TerminalNode IDENTIFIANT(int i) {
			return getToken(CalculetteParser.IDENTIFIANT, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			((ParamsContext)_localctx).TYPE = match(TYPE);
			setState(262);
			((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

			            tablesSymboles.putVar((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null), (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
			            ((ParamsContext)_localctx).code =  "";


			        
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(264);
				match(T__14);
				setState(265);
				((ParamsContext)_localctx).TYPE = match(TYPE);
				setState(266);
				((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				              tablesSymboles.putVar((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null), (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
				                // code java gérant une variable locale (argi)
				            
				}
				}
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ArgsContext extends ParserRuleContext {
		public String code;
		public int size;
		public ExprContext expr;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_args);
		 ((ArgsContext)_localctx).code =  new String(); ((ArgsContext)_localctx).size =  0; 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__18) | (1L << IDENTIFIANT) | (1L << ENTIER))) != 0)) {
				{
				setState(273);
				((ArgsContext)_localctx).expr = expr(0);

				      _localctx.code += ((ArgsContext)_localctx).expr.code;
				      ((ArgsContext)_localctx).size =  1;
				        // code java pour première expression pour arg
				    
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(275);
					match(T__14);
					setState(276);
					((ArgsContext)_localctx).expr = expr(0);

					      _localctx.code += ((ArgsContext)_localctx).expr.code;
					      _localctx.size += 1;
					    
					}
					}
					setState(283);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class ExprContext extends ParserRuleContext {
		public String code;
		public String type;
		public ExprContext a;
		public Token ENTIER;
		public Token IDENTIFIANT;
		public ArgsContext args;
		public Token op;
		public ExprContext b;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ENTIER() { return getToken(CalculetteParser.ENTIER, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(287);
				match(T__2);
				setState(288);
				((ExprContext)_localctx).a = expr(0);
				setState(289);
				match(T__3);
				((ExprContext)_localctx).code =  ((ExprContext)_localctx).a.code;
				}
				break;
			case 2:
				{
				setState(292);
				((ExprContext)_localctx).ENTIER = match(ENTIER);
				((ExprContext)_localctx).code =  "PUSHI "+(((ExprContext)_localctx).ENTIER!=null?((ExprContext)_localctx).ENTIER.getText():null)+"\n";
				}
				break;
			case 3:
				{
				setState(294);
				match(T__18);
				setState(295);
				((ExprContext)_localctx).ENTIER = match(ENTIER);
				((ExprContext)_localctx).code =  "PUSHI 0\nPUSHI " +(((ExprContext)_localctx).ENTIER!=null?((ExprContext)_localctx).ENTIER.getText():null) + "\nSUB\n";
				}
				break;
			case 4:
				{
				setState(297);
				((ExprContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				        int adr = tablesSymboles.getAdresseType((((ExprContext)_localctx).IDENTIFIANT!=null?((ExprContext)_localctx).IDENTIFIANT.getText():null)).adresse;
				        String push = posif("push", adr);
				        ((ExprContext)_localctx).code =  push + adr +"\n";
				    
				}
				break;
			case 5:
				{
				setState(299);
				((ExprContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(300);
				match(T__2);
				setState(301);
				((ExprContext)_localctx).args = args();
				setState(302);
				match(T__3);

				        ((ExprContext)_localctx).code =  "PUSHI 0\n";
				        _localctx.code += ((ExprContext)_localctx).args.code + "CALL "+tablesSymboles.getFunction((((ExprContext)_localctx).IDENTIFIANT!=null?((ExprContext)_localctx).IDENTIFIANT.getText():null)).adresse + "\n";
				        _localctx.code += "RETURN\n";
				        for(int i = 0; i < ((ExprContext)_localctx).args.size; i++)
				        {
				            _localctx.code+= "POP\n";
				        }
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(319);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(317);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(307);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(308);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__15 || _la==T__16) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(309);
						((ExprContext)_localctx).b = expr(7);
						((ExprContext)_localctx).code =  evalexpr(((ExprContext)_localctx).a.code, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).b.code);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(312);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(313);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__17 || _la==T__18) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(314);
						((ExprContext)_localctx).b = expr(6);
						((ExprContext)_localctx).code =  evalexpr(((ExprContext)_localctx).a.code, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).b.code);
						}
						break;
					}
					} 
				}
				setState(321);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public String code;
		public ConditionContext c1;
		public ExprContext a;
		public Token op;
		public ExprContext b;
		public ConditionContext condition;
		public ConditionContext c2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_condition, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__18:
			case IDENTIFIANT:
			case ENTIER:
				{
				setState(323);
				((ConditionContext)_localctx).a = expr(0);
				setState(324);
				((ConditionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
					((ConditionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(325);
				((ConditionContext)_localctx).b = expr(0);

				      ((ConditionContext)_localctx).code =  evalexpr(((ConditionContext)_localctx).a.code, (((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null), ((ConditionContext)_localctx).b.code);
				    
				}
				break;
			case T__28:
				{
				setState(328);
				match(T__28);
				setState(329);
				((ConditionContext)_localctx).condition = condition(3);
				((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).condition.code + "PUSHI 1\nNEQ\n";
				}
				break;
			case T__29:
				{
				setState(332);
				match(T__29);
				 ((ConditionContext)_localctx).code =  "  PUSHI 1\n"; 
				}
				break;
			case T__30:
				{
				setState(334);
				match(T__30);
				 ((ConditionContext)_localctx).code =  "  PUSHI 0\n"; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(350);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(348);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.c1 = _prevctx;
						_localctx.c1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(338);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(339);
						match(T__26);
						setState(340);
						((ConditionContext)_localctx).c2 = ((ConditionContext)_localctx).condition = condition(6);

						                  ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).c1.code + ((ConditionContext)_localctx).c2.code + "MUL\n";
						              
						}
						break;
					case 2:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.c1 = _prevctx;
						_localctx.c1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(343);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(344);
						match(T__27);
						setState(345);
						((ConditionContext)_localctx).c2 = ((ConditionContext)_localctx).condition = condition(5);

						                  ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).c1.code + ((ConditionContext)_localctx).c2.code + "ADD\n";
						              
						}
						break;
					}
					} 
				}
				setState(352);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 13:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u0164\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\3\3\3\3\3\7\3%\n"+
		"\3\f\3\16\3(\13\3\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\3\3\3\3\3\7\3\64\n"+
		"\3\f\3\16\3\67\13\3\3\3\7\3:\n\3\f\3\16\3=\13\3\3\3\3\3\3\3\3\3\7\3C\n"+
		"\3\f\3\16\3F\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4V\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5v"+
		"\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0087"+
		"\n\5\3\5\3\5\5\5\u008b\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0096"+
		"\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00a4\n\5\3\5"+
		"\3\5\3\5\3\5\3\5\5\5\u00ab\n\5\3\5\3\5\5\5\u00af\n\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u00bc\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00c4"+
		"\n\6\3\7\3\7\3\7\3\7\3\7\5\7\u00cb\n\7\3\7\3\7\3\7\3\7\5\7\u00d1\n\7\3"+
		"\7\3\7\3\7\3\7\5\7\u00d7\n\7\3\7\3\7\3\7\5\7\u00dc\n\7\3\b\3\b\3\b\3\b"+
		"\7\b\u00e2\n\b\f\b\16\b\u00e5\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\6\n"+
		"\u00ef\n\n\r\n\16\n\u00f0\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0106\n\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u010f\n\f\f\f\16\f\u0112\13\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\7\r\u011a\n\r\f\r\16\r\u011d\13\r\5\r\u011f\n\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u0134\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\7\16\u0140\n\16\f\16\16\16\u0143\13\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0153\n\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u015f\n\17\f\17\16"+
		"\17\u0162\13\17\3\17\2\4\32\34\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\2\6\4\2\f\f&&\3\2\22\23\3\2\24\25\3\2\26\34\2\u0184\2\36\3\2\2\2\4&\3"+
		"\2\2\2\6U\3\2\2\2\b\u00bb\3\2\2\2\n\u00c3\3\2\2\2\f\u00db\3\2\2\2\16\u00dd"+
		"\3\2\2\2\20\u00e8\3\2\2\2\22\u00ee\3\2\2\2\24\u0105\3\2\2\2\26\u0107\3"+
		"\2\2\2\30\u011e\3\2\2\2\32\u0133\3\2\2\2\34\u0152\3\2\2\2\36\37\5\4\3"+
		"\2\37 \7\2\2\3 \3\3\2\2\2!\"\5\6\4\2\"#\b\3\1\2#%\3\2\2\2$!\3\2\2\2%("+
		"\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2)-\b\3\1\2*,\7&\2\2"+
		"+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\65\3\2\2\2/-\3\2\2\2\60\61\5"+
		"\24\13\2\61\62\b\3\1\2\62\64\3\2\2\2\63\60\3\2\2\2\64\67\3\2\2\2\65\63"+
		"\3\2\2\2\65\66\3\2\2\2\66;\3\2\2\2\67\65\3\2\2\28:\7&\2\298\3\2\2\2:="+
		"\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>D\b\3\1\2?@\5\b\5\2@"+
		"A\b\3\1\2AC\3\2\2\2B?\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2"+
		"FD\3\2\2\2GH\b\3\1\2H\5\3\2\2\2IJ\7$\2\2JK\7%\2\2KL\5\22\n\2LM\b\4\1\2"+
		"MV\3\2\2\2NO\7$\2\2OP\7%\2\2PQ\7\3\2\2QR\5\32\16\2RS\5\22\n\2ST\b\4\1"+
		"\2TV\3\2\2\2UI\3\2\2\2UN\3\2\2\2V\7\3\2\2\2WX\5\32\16\2XY\5\22\n\2YZ\b"+
		"\5\1\2Z\u00bc\3\2\2\2[\\\5\20\t\2\\]\5\22\n\2]^\b\5\1\2^\u00bc\3\2\2\2"+
		"_`\5\22\n\2`a\b\5\1\2a\u00bc\3\2\2\2bc\7\4\2\2cd\7\5\2\2de\5\32\16\2e"+
		"f\7\6\2\2fg\5\22\n\2gh\b\5\1\2h\u00bc\3\2\2\2ij\7\7\2\2jk\7\5\2\2kl\7"+
		"%\2\2lm\7\6\2\2mn\5\22\n\2no\b\5\1\2o\u00bc\3\2\2\2pq\7\b\2\2qr\7\5\2"+
		"\2rs\5\34\17\2su\7\6\2\2tv\7&\2\2ut\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\5\16"+
		"\b\2xy\b\5\1\2y\u00bc\3\2\2\2z{\7\b\2\2{|\7\5\2\2|}\5\34\17\2}~\7\6\2"+
		"\2~\177\5\b\5\2\177\u0080\b\5\1\2\u0080\u00bc\3\2\2\2\u0081\u0082\7\t"+
		"\2\2\u0082\u0083\7\5\2\2\u0083\u0084\5\34\17\2\u0084\u0086\7\6\2\2\u0085"+
		"\u0087\7&\2\2\u0086\u0085\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\u008a\5\n\6\2\u0089\u008b\7&\2\2\u008a\u0089\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\7\n\2\2\u008d\u008e\5\f"+
		"\7\2\u008e\u008f\b\5\1\2\u008f\u00bc\3\2\2\2\u0090\u0091\7\t\2\2\u0091"+
		"\u0092\7\5\2\2\u0092\u0093\5\34\17\2\u0093\u0095\7\6\2\2\u0094\u0096\7"+
		"&\2\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0098\5\n\6\2\u0098\u0099\b\5\1\2\u0099\u00bc\3\2\2\2\u009a\u009b\7\13"+
		"\2\2\u009b\u009c\7\5\2\2\u009c\u009d\5\20\t\2\u009d\u009e\7\f\2\2\u009e"+
		"\u009f\5\34\17\2\u009f\u00a0\7\f\2\2\u00a0\u00a1\5\20\t\2\u00a1\u00a3"+
		"\7\6\2\2\u00a2\u00a4\7&\2\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00a6\5\n\6\2\u00a6\u00a7\b\5\1\2\u00a7\u00bc\3\2"+
		"\2\2\u00a8\u00aa\7\r\2\2\u00a9\u00ab\7&\2\2\u00aa\u00a9\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\5\16\b\2\u00ad\u00af\7"+
		"&\2\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00b1\7\16\2\2\u00b1\u00b2\7\5\2\2\u00b2\u00b3\5\34\17\2\u00b3\u00b4"+
		"\7\6\2\2\u00b4\u00b5\b\5\1\2\u00b5\u00bc\3\2\2\2\u00b6\u00b7\7#\2\2\u00b7"+
		"\u00b8\5\32\16\2\u00b8\u00b9\5\22\n\2\u00b9\u00ba\b\5\1\2\u00ba\u00bc"+
		"\3\2\2\2\u00bbW\3\2\2\2\u00bb[\3\2\2\2\u00bb_\3\2\2\2\u00bbb\3\2\2\2\u00bb"+
		"i\3\2\2\2\u00bbp\3\2\2\2\u00bbz\3\2\2\2\u00bb\u0081\3\2\2\2\u00bb\u0090"+
		"\3\2\2\2\u00bb\u009a\3\2\2\2\u00bb\u00a8\3\2\2\2\u00bb\u00b6\3\2\2\2\u00bc"+
		"\t\3\2\2\2\u00bd\u00be\5\b\5\2\u00be\u00bf\b\6\1\2\u00bf\u00c4\3\2\2\2"+
		"\u00c0\u00c1\5\16\b\2\u00c1\u00c2\b\6\1\2\u00c2\u00c4\3\2\2\2\u00c3\u00bd"+
		"\3\2\2\2\u00c3\u00c0\3\2\2\2\u00c4\13\3\2\2\2\u00c5\u00c6\7\t\2\2\u00c6"+
		"\u00c7\7\5\2\2\u00c7\u00c8\5\34\17\2\u00c8\u00ca\7\6\2\2\u00c9\u00cb\7"+
		"&\2\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00cd\5\n\6\2\u00cd\u00ce\b\7\1\2\u00ce\u00dc\3\2\2\2\u00cf\u00d1\7&"+
		"\2\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2"+
		"\u00d3\5\16\b\2\u00d3\u00d4\b\7\1\2\u00d4\u00dc\3\2\2\2\u00d5\u00d7\7"+
		"&\2\2\u00d6\u00d5\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\u00d9\5\b\5\2\u00d9\u00da\b\7\1\2\u00da\u00dc\3\2\2\2\u00db\u00c5\3\2"+
		"\2\2\u00db\u00d0\3\2\2\2\u00db\u00d6\3\2\2\2\u00dc\r\3\2\2\2\u00dd\u00e3"+
		"\7\17\2\2\u00de\u00df\5\b\5\2\u00df\u00e0\b\b\1\2\u00e0\u00e2\3\2\2\2"+
		"\u00e1\u00de\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4"+
		"\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00e7\7\20\2\2"+
		"\u00e7\17\3\2\2\2\u00e8\u00e9\7%\2\2\u00e9\u00ea\7\3\2\2\u00ea\u00eb\5"+
		"\32\16\2\u00eb\u00ec\b\t\1\2\u00ec\21\3\2\2\2\u00ed\u00ef\t\2\2\2\u00ee"+
		"\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00f1\3\2"+
		"\2\2\u00f1\23\3\2\2\2\u00f2\u00f3\7$\2\2\u00f3\u00f4\7%\2\2\u00f4\u00f5"+
		"\b\13\1\2\u00f5\u00f6\7\5\2\2\u00f6\u00f7\5\26\f\2\u00f7\u00f8\7\6\2\2"+
		"\u00f8\u00f9\b\13\1\2\u00f9\u00fa\5\16\b\2\u00fa\u00fb\b\13\1\2\u00fb"+
		"\u0106\3\2\2\2\u00fc\u00fd\7$\2\2\u00fd\u00fe\7%\2\2\u00fe\u00ff\b\13"+
		"\1\2\u00ff\u0100\7\5\2\2\u0100\u0101\7\6\2\2\u0101\u0102\b\13\1\2\u0102"+
		"\u0103\5\16\b\2\u0103\u0104\b\13\1\2\u0104\u0106\3\2\2\2\u0105\u00f2\3"+
		"\2\2\2\u0105\u00fc\3\2\2\2\u0106\25\3\2\2\2\u0107\u0108\7$\2\2\u0108\u0109"+
		"\7%\2\2\u0109\u0110\b\f\1\2\u010a\u010b\7\21\2\2\u010b\u010c\7$\2\2\u010c"+
		"\u010d\7%\2\2\u010d\u010f\b\f\1\2\u010e\u010a\3\2\2\2\u010f\u0112\3\2"+
		"\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\27\3\2\2\2\u0112\u0110"+
		"\3\2\2\2\u0113\u0114\5\32\16\2\u0114\u011b\b\r\1\2\u0115\u0116\7\21\2"+
		"\2\u0116\u0117\5\32\16\2\u0117\u0118\b\r\1\2\u0118\u011a\3\2\2\2\u0119"+
		"\u0115\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2"+
		"\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u0113\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\31\3\2\2\2\u0120\u0121\b\16\1\2\u0121\u0122\7\5\2"+
		"\2\u0122\u0123\5\32\16\2\u0123\u0124\7\6\2\2\u0124\u0125\b\16\1\2\u0125"+
		"\u0134\3\2\2\2\u0126\u0127\7(\2\2\u0127\u0134\b\16\1\2\u0128\u0129\7\25"+
		"\2\2\u0129\u012a\7(\2\2\u012a\u0134\b\16\1\2\u012b\u012c\7%\2\2\u012c"+
		"\u0134\b\16\1\2\u012d\u012e\7%\2\2\u012e\u012f\7\5\2\2\u012f\u0130\5\30"+
		"\r\2\u0130\u0131\7\6\2\2\u0131\u0132\b\16\1\2\u0132\u0134\3\2\2\2\u0133"+
		"\u0120\3\2\2\2\u0133\u0126\3\2\2\2\u0133\u0128\3\2\2\2\u0133\u012b\3\2"+
		"\2\2\u0133\u012d\3\2\2\2\u0134\u0141\3\2\2\2\u0135\u0136\f\b\2\2\u0136"+
		"\u0137\t\3\2\2\u0137\u0138\5\32\16\t\u0138\u0139\b\16\1\2\u0139\u0140"+
		"\3\2\2\2\u013a\u013b\f\7\2\2\u013b\u013c\t\4\2\2\u013c\u013d\5\32\16\b"+
		"\u013d\u013e\b\16\1\2\u013e\u0140\3\2\2\2\u013f\u0135\3\2\2\2\u013f\u013a"+
		"\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142"+
		"\33\3\2\2\2\u0143\u0141\3\2\2\2\u0144\u0145\b\17\1\2\u0145\u0146\5\32"+
		"\16\2\u0146\u0147\t\5\2\2\u0147\u0148\5\32\16\2\u0148\u0149\b\17\1\2\u0149"+
		"\u0153\3\2\2\2\u014a\u014b\7\37\2\2\u014b\u014c\5\34\17\5\u014c\u014d"+
		"\b\17\1\2\u014d\u0153\3\2\2\2\u014e\u014f\7 \2\2\u014f\u0153\b\17\1\2"+
		"\u0150\u0151\7!\2\2\u0151\u0153\b\17\1\2\u0152\u0144\3\2\2\2\u0152\u014a"+
		"\3\2\2\2\u0152\u014e\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0160\3\2\2\2\u0154"+
		"\u0155\f\7\2\2\u0155\u0156\7\35\2\2\u0156\u0157\5\34\17\b\u0157\u0158"+
		"\b\17\1\2\u0158\u015f\3\2\2\2\u0159\u015a\f\6\2\2\u015a\u015b\7\36\2\2"+
		"\u015b\u015c\5\34\17\7\u015c\u015d\b\17\1\2\u015d\u015f\3\2\2\2\u015e"+
		"\u0154\3\2\2\2\u015e\u0159\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2"+
		"\2\2\u0160\u0161\3\2\2\2\u0161\35\3\2\2\2\u0162\u0160\3\2\2\2!&-\65;D"+
		"Uu\u0086\u008a\u0095\u00a3\u00aa\u00ae\u00bb\u00c3\u00ca\u00d0\u00d6\u00db"+
		"\u00e3\u00f0\u0105\u0110\u011b\u011e\u0133\u013f\u0141\u0152\u015e\u0160";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
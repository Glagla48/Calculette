// Generated from Calculette.g4 by ANTLR 4.7.2
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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		COMMENT=32, BREAK=33, CONTINUE=34, BOOLEAN=35, RETURN=36, TYPE=37, IDENTIFIANT=38, 
		NEWLINE=39, WS=40, ENTIER=41, UNMATCH=42;
	public static final int
		RULE_start = 0, RULE_calcul = 1, RULE_decl = 2, RULE_instruction = 3, 
		RULE_instructionthen = 4, RULE_instructionelse = 5, RULE_bloc = 6, RULE_assignation = 7, 
		RULE_finInstruction = 8, RULE_fonction = 9, RULE_params = 10, RULE_args = 11, 
		RULE_expr = 12, RULE_condition = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "calcul", "decl", "instruction", "instructionthen", "instructionelse", 
			"bloc", "assignation", "finInstruction", "fonction", "params", "args", 
			"expr", "condition"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'write'", "'('", "')'", "'read'", "'while'", "'if'", "'else'", 
			"'for'", "';'", "'repeat'", "'until'", "'{'", "'}'", "','", "'*'", "'/'", 
			"'+'", "'-'", "'.'", "'++'", "'<'", "'<='", "'=='", "'!='", "'>'", "'>='", 
			"'<>'", "'&&'", "'||'", "'!'", null, "'break'", "'continue'", null, "'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "COMMENT", "BREAK", "CONTINUE", 
			"BOOLEAN", "RETURN", "TYPE", "IDENTIFIANT", "NEWLINE", "WS", "ENTIER", 
			"UNMATCH"
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

	    private int label_break;
	    private int label_continue;

	    private String evalexpr (String x, String op, String y, String type) {
	        if(type.equals("int"))
	        {
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
	        else
	        {
	             if ( op.equals("*") ){
	              return x+y+"FMUL\n";
	          } else if ( op.equals("+") ){
	              return x+y+"FADD\n";
	          } else if ( op.equals("/") ){
	              if(y == "0")
	              {
	              System.err.println("Impossible de diviser par 0");
	              throw new IllegalArgumentException("Impossible de diviser par 0");
	            }
	            return x+y+"FDIV \n";
	        } else if ( op.equals("-") ){
	            return x+y+"FSUB \n";
	        }
	         else if(op.equals("<"))
	        {
	            return x + y + "FINF \n";
	        }
	        else if(op.equals("<="))
	        {
	            return x + y + "FINFEQ\n";
	        }
	        else if(op.equals("=="))
	        {
	            return x + y + "FEQUAL\n";
	        }
	        else if(op.equals("!=") || op.equals("<>"))
	        {
	            return x + y + "FNEQ\n";
	        }
	        else if(op.equals(">"))
	        {
	            return x + y + "FSUP\n";
	        }
	        else if(op.equals(">="))
	        {
	            return x + y + "FSUPEQ \n";
	        }else {
	           System.err.println("Opérateur arithmétique incorrect : '"+op+"'");
	           throw new IllegalArgumentException("Opérateur arithmétique incorrect : '"+op+"'");
	        }
	        }

	    }

	    //pushOrStoreInFunction
	    private String posif(String pushOrStore, AdresseType at)
	    {
	        int adr = at.adresse;
	        String type = at.type;

	        if(pushOrStore.equals("push"))
	        {
	            if(adr < 0){
	                if(type.equals("float")){
	                  int adr2 = adr + 1;
	                  return "PUSHL "+adr+"\n"+"PUSHL "+adr2+"\n";
	                }else{
	                  return "PUSHL "+adr+"\n";
	                }
	            }else{
	              if(type.equals("float")){
	                int adr2 = adr + 1;
	                return "PUSHG "+adr2+"\n"+"PUSHG "+adr+"\n";
	              }else{
	                return "PUSHG "+adr+"\n";
	              }
	            }
	        }else{
	            if(adr < 0){
	              if(type.equals("float")){
	                int adr2 = adr + 1;
	                return "STOREL "+adr2+"\n"+"STOREL "+adr+"\n";
	              }else{
	                return "STOREL "+adr+"\n";
	              }
	            }else{
	              if(type.equals("float")){
	                int adr2 = adr + 1;
	                return "STOREG "+adr+"\n"+"STOREG "+adr2+"\n";
	              }else{
	                return "STOREG "+adr+"\n";
	              }
	            }
	        }
	    }

	//t1 = type du cast     t2 = type de l'expression
	    private String cast(String t1, String t2)
	    {
	      if(t1.equals("float"))
	      {
	        if(t2.equals("int")){
	          return "ITOF \n";
	        }else if(t2.equals("bool")){
	          return "ITOF \n";
	        }else{
	          return "";
	        }
	      }
	      else if(t1.equals("int"))
	      {
	        if(t2.equals("float")){
	          return "FTOI \n";
	        }else if(t2.equals("bool")){
	          return "";
	        }else{
	          return "";
	        }
	      }
	      else
	      {
	        if(t2.equals("float")){
	          return "FTOI \n";
	        }else if(t2.equals("int")){
	          return "";
	        }else{
	          return "";
	        }
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitStart(this);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterCalcul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitCalcul(this);
		}
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
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(46);
				((CalculContext)_localctx).fonction = fonction();
				 _localctx.code += ((CalculContext)_localctx).fonction.code; 
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(48);
						match(NEWLINE);
						}
						} 
					}
					setState(53);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(59);
					match(NEWLINE);
					}
					} 
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			 _localctx.code += "LABEL " + entry + "\n"; 
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__18) | (1L << BREAK) | (1L << CONTINUE) | (1L << BOOLEAN) | (1L << RETURN) | (1L << IDENTIFIANT) | (1L << NEWLINE) | (1L << ENTIER))) != 0)) {
				{
				{
				setState(66);
				((CalculContext)_localctx).instruction = instruction();
				 _localctx.code += ((CalculContext)_localctx).instruction.code; 
				}
				}
				setState(73);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(77);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(78);
				finInstruction();

				          tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null), (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));

				          if((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("float"))
				            ((DeclContext)_localctx).code =  "PUSHF 0.0\n";
				          else
				            ((DeclContext)_localctx).code =  "PUSHI 0\n";
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81);
				((DeclContext)_localctx).TYPE = match(TYPE);
				setState(82);
				((DeclContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(83);
				match(T__0);
				setState(84);
				((DeclContext)_localctx).expr = expr(0);
				setState(85);
				finInstruction();

				        tablesSymboles.putVar((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null), (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null));
				        AdresseType at = tablesSymboles.getAdresseType((((DeclContext)_localctx).IDENTIFIANT!=null?((DeclContext)_localctx).IDENTIFIANT.getText():null));
				        String store = posif("store", at);

				        ((DeclContext)_localctx).expr.type = (((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null);
				        if((((DeclContext)_localctx).TYPE!=null?((DeclContext)_localctx).TYPE.getText():null).equals("float"))
				        {
				          ((DeclContext)_localctx).code =  "PUSHF 0.0\n" + ((DeclContext)_localctx).expr.code + "\n" + store;
				        }
				        else
				          ((DeclContext)_localctx).code = "PUSHI 0\n" + ((DeclContext)_localctx).expr.code + "\n" + store;
				    
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
		public TerminalNode BREAK() { return getToken(CalculetteParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(CalculetteParser.CONTINUE, 0); }
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instruction);
		int _la;
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				((InstructionContext)_localctx).expr = expr(0);
				setState(91);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expr.code;
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				((InstructionContext)_localctx).assignation = assignation();
				setState(95);
				finInstruction();

				            ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).assignation.code;
				        
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				finInstruction();

				            ((InstructionContext)_localctx).code = "";
				        
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				match(T__1);
				setState(102);
				match(T__2);
				setState(103);
				((InstructionContext)_localctx).expr = expr(0);
				setState(104);
				match(T__3);
				setState(105);
				finInstruction();

				        String write  = ((InstructionContext)_localctx).expr.type.equals("float") ? "WRITEF\nPOP\nPOP\n" : "WRITE\nPOP\n";
				        ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expr.code + write;
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(108);
				match(T__4);
				setState(109);
				match(T__2);
				setState(110);
				((InstructionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(111);
				match(T__3);
				setState(112);
				finInstruction();

				        AdresseType at = tablesSymboles.getAdresseType((((InstructionContext)_localctx).IDENTIFIANT!=null?((InstructionContext)_localctx).IDENTIFIANT.getText():null));
				        String store = posif("store", at);
				        String read = at.type.equals("float") ? "READF\n" : "READ\n";
				        ((InstructionContext)_localctx).code =  read + store;
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(115);
				match(T__5);
				setState(116);
				match(T__2);
				setState(117);
				((InstructionContext)_localctx).condition = condition(0);
				setState(118);
				match(T__3);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(119);
					match(NEWLINE);
					}
				}

				setState(122);
				((InstructionContext)_localctx).bloc = bloc();

				        int labelA = nextLabel();
				        label_continue = _cur_label;
				        int labelB = nextLabel();
				        label_break  = _cur_label;
				        ((InstructionContext)_localctx).code =  "LABEL " + labelA + "\n" + ((InstructionContext)_localctx).condition.code + "JUMPF " + labelB + "\n" + ((InstructionContext)_localctx).bloc.code + "JUMP " + labelA + "\n" +"LABEL " + labelB + "\n";
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(125);
				match(T__5);
				setState(126);
				match(T__2);
				setState(127);
				((InstructionContext)_localctx).condition = condition(0);
				setState(128);
				match(T__3);
				setState(129);
				((InstructionContext)_localctx).instruction = instruction();

				      int labelA = nextLabel();
				      label_continue = _cur_label;
				      int labelB = nextLabel();
				      label_break  = _cur_label;

				        ((InstructionContext)_localctx).code =  "LABEL " + labelA + "\n" + ((InstructionContext)_localctx).condition.code + "JUMPF " + labelB + "\n" + ((InstructionContext)_localctx).instruction.code + "JUMP " + labelA + "\n" + "LABEL " + labelB + "\n";
				    
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(132);
				match(T__6);
				setState(133);
				match(T__2);
				setState(134);
				((InstructionContext)_localctx).condition = condition(0);
				setState(135);
				match(T__3);
				setState(137);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(136);
					match(NEWLINE);
					}
					break;
				}
				setState(139);
				((InstructionContext)_localctx).instructionthen = instructionthen();
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(140);
					match(NEWLINE);
					}
				}

				setState(143);
				match(T__7);
				setState(144);
				((InstructionContext)_localctx).instructionelse = instructionelse();

				      int l1 = nextLabel();
				      int l2 = nextLabel();
				      label_continue = l2;
				      ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).condition.code + "JUMPF " + l1 + "\n" + ((InstructionContext)_localctx).instructionthen.code + "JUMP " + l2 + "\n"
				      + "LABEL " + l1 + "\n" + ((InstructionContext)_localctx).instructionelse.code + "LABEL " + l2 + "\n";
				    
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(147);
				match(T__6);
				setState(148);
				match(T__2);
				setState(149);
				((InstructionContext)_localctx).condition = condition(0);
				setState(150);
				match(T__3);
				setState(152);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(151);
					match(NEWLINE);
					}
					break;
				}
				setState(154);
				((InstructionContext)_localctx).instructionthen = instructionthen();

				      int l1 = nextLabel();
				      label_continue = l1;
				      ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).condition.code + "JUMPF " + l1 + "\n" + ((InstructionContext)_localctx).instructionthen.code + "LABEL " + l1 + "\n";
				    
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(157);
				match(T__8);
				setState(158);
				match(T__2);
				setState(159);
				((InstructionContext)_localctx).a1 = assignation();
				setState(160);
				match(T__9);
				setState(161);
				((InstructionContext)_localctx).condition = condition(0);
				setState(162);
				match(T__9);
				setState(163);
				((InstructionContext)_localctx).a2 = assignation();
				setState(164);
				match(T__3);
				setState(166);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(165);
					match(NEWLINE);
					}
					break;
				}
				setState(168);
				((InstructionContext)_localctx).instructionthen = instructionthen();

				      int l1 = nextLabel();
				      int l2 = nextLabel();
				      label_continue = l1;
				      label_break = l2;
				      ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).a1.code + "LABEL " + l1 + "\n" + ((InstructionContext)_localctx).condition.code + "JUMPF " + l2
				      + "\n"  + ((InstructionContext)_localctx).instructionthen.code + ((InstructionContext)_localctx).a2.code + "JUMP " + l1 +"\n"+ "LABEL " + l2 + "\n";
				    
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(171);
				match(T__10);
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(172);
					match(NEWLINE);
					}
				}

				setState(175);
				((InstructionContext)_localctx).bloc = bloc();
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(176);
					match(NEWLINE);
					}
				}

				setState(179);
				match(T__11);
				setState(180);
				match(T__2);
				setState(181);
				((InstructionContext)_localctx).condition = condition(0);
				setState(182);
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
				setState(185);
				match(RETURN);
				setState(186);
				((InstructionContext)_localctx).expr = expr(0);
				setState(187);
				finInstruction();

				        int adr = tablesSymboles.getAdresseType("return").adresse;
				        int adr2 = adr + 1;

				        if(((InstructionContext)_localctx).expr.type.equals("float"))
				        {
				          ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expr.code + "STOREL "+ adr2 + "\n";
				          _localctx.code += "STOREL "+ adr + "\n";
				        }
				        else{
				          ((InstructionContext)_localctx).code =  ((InstructionContext)_localctx).expr.code + "STOREL "+ adr + "\n";
				        }
				        _localctx.code += "RETURN\n";
				    
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(190);
				match(BREAK);
				setState(191);
				finInstruction();

				      label_break = label_break + 2;
				      ((InstructionContext)_localctx).code =  "JUMP " + label_break +"\n";
				    
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(194);
				match(CONTINUE);
				setState(195);
				finInstruction();

				      label_continue = label_continue + 1;
				      ((InstructionContext)_localctx).code =  "JUMP " +  label_continue +"\n";
				    
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterInstructionthen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitInstructionthen(this);
		}
	}

	public final InstructionthenContext instructionthen() throws RecognitionException {
		InstructionthenContext _localctx = new InstructionthenContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_instructionthen);
		try {
			setState(206);
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
			case BREAK:
			case CONTINUE:
			case BOOLEAN:
			case RETURN:
			case IDENTIFIANT:
			case NEWLINE:
			case ENTIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				((InstructionthenContext)_localctx).instruction = instruction();
				((InstructionthenContext)_localctx).code =  ((InstructionthenContext)_localctx).instruction.code;
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterInstructionelse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitInstructionelse(this);
		}
	}

	public final InstructionelseContext instructionelse() throws RecognitionException {
		InstructionelseContext _localctx = new InstructionelseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_instructionelse);
		int _la;
		try {
			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				match(T__6);
				setState(209);
				match(T__2);
				setState(210);
				((InstructionelseContext)_localctx).condition = condition(0);
				setState(211);
				match(T__3);
				setState(213);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(212);
					match(NEWLINE);
					}
					break;
				}
				setState(215);
				((InstructionelseContext)_localctx).instructionthen = instructionthen();

				        ((InstructionelseContext)_localctx).code =  ((InstructionelseContext)_localctx).condition.code + "JUMPF " + nextLabel() + "\n" + ((InstructionelseContext)_localctx).instructionthen.code + "LABEL " + _cur_label + "\n";
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWLINE) {
					{
					setState(218);
					match(NEWLINE);
					}
				}

				setState(221);
				((InstructionelseContext)_localctx).bloc = bloc();

				        ((InstructionelseContext)_localctx).code =  ((InstructionelseContext)_localctx).bloc.code;
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(225);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(224);
					match(NEWLINE);
					}
					break;
				}
				setState(227);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterBloc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitBloc(this);
		}
	}

	public final BlocContext bloc() throws RecognitionException {
		BlocContext _localctx = new BlocContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_bloc);
		((BlocContext)_localctx).code =  new String();
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(T__12);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__18) | (1L << BREAK) | (1L << CONTINUE) | (1L << BOOLEAN) | (1L << RETURN) | (1L << IDENTIFIANT) | (1L << NEWLINE) | (1L << ENTIER))) != 0)) {
				{
				{
				setState(233);
				((BlocContext)_localctx).instruction = instruction();
				_localctx.code += ((BlocContext)_localctx).instruction.code;
				}
				}
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(241);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterAssignation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitAssignation(this);
		}
	}

	public final AssignationContext assignation() throws RecognitionException {
		AssignationContext _localctx = new AssignationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_assignation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			((AssignationContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
			setState(244);
			match(T__0);
			setState(245);
			((AssignationContext)_localctx).expr = expr(0);

			            AdresseType at = tablesSymboles.getAdresseType((((AssignationContext)_localctx).IDENTIFIANT!=null?((AssignationContext)_localctx).IDENTIFIANT.getText():null));

			            String store = posif("store", at);
			            ((AssignationContext)_localctx).code =  ((AssignationContext)_localctx).expr.code + store;
			        
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterFinInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitFinInstruction(this);
		}
	}

	public final FinInstructionContext finInstruction() throws RecognitionException {
		FinInstructionContext _localctx = new FinInstructionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_finInstruction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(249); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(248);
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
				setState(251); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterFonction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitFonction(this);
		}
	}

	public final FonctionContext fonction() throws RecognitionException {
		FonctionContext _localctx = new FonctionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_fonction);
		tablesSymboles.newTableLocale();
		try {
			setState(272);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				((FonctionContext)_localctx).TYPE = match(TYPE);
				setState(254);
				((FonctionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				tablesSymboles.putVar("return", (((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
				setState(256);
				match(T__2);
				setState(257);
				((FonctionContext)_localctx).params = params();
				setState(258);
				match(T__3);

				            int l = nextLabel();
				            tablesSymboles.newFunction((((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null), l, (((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
				            ((FonctionContext)_localctx).code =  "LABEL "+ l + "\n";
				            _localctx.code += ((FonctionContext)_localctx).params.code;
				            // truc à faire par rapport au code += "LABEL " + entry + "\n"; }

				        
				setState(260);
				((FonctionContext)_localctx).bloc = bloc();

				            _localctx.code += ((FonctionContext)_localctx).bloc.code;
				            _localctx.code += "RETURN\n";
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				((FonctionContext)_localctx).TYPE = match(TYPE);
				setState(264);
				((FonctionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				tablesSymboles.putVar("return", (((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
				setState(266);
				match(T__2);
				setState(267);
				match(T__3);

				            int l = nextLabel();
				            tablesSymboles.newFunction((((FonctionContext)_localctx).IDENTIFIANT!=null?((FonctionContext)_localctx).IDENTIFIANT.getText():null), l, (((FonctionContext)_localctx).TYPE!=null?((FonctionContext)_localctx).TYPE.getText():null));
				            ((FonctionContext)_localctx).code =  "LABEL "+ l + "\n";
				            // truc à faire par rapport au code += "LABEL " + entry + "\n"; }

				        
				setState(269);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			((ParamsContext)_localctx).TYPE = match(TYPE);
			setState(275);
			((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

			            tablesSymboles.putVar((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null), (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
			            ((ParamsContext)_localctx).code =  "";
			        
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(277);
				match(T__14);
				setState(278);
				((ParamsContext)_localctx).TYPE = match(TYPE);
				setState(279);
				((ParamsContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				              tablesSymboles.putVar((((ParamsContext)_localctx).IDENTIFIANT!=null?((ParamsContext)_localctx).IDENTIFIANT.getText():null), (((ParamsContext)_localctx).TYPE!=null?((ParamsContext)_localctx).TYPE.getText():null));
				                // code java gérant une variable locale (argi)
				            
				}
				}
				setState(285);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_args);
		 ((ArgsContext)_localctx).code =  new String(); ((ArgsContext)_localctx).size =  0; 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__18) | (1L << BOOLEAN) | (1L << IDENTIFIANT) | (1L << ENTIER))) != 0)) {
				{
				setState(286);
				((ArgsContext)_localctx).expr = expr(0);

				      _localctx.code += ((ArgsContext)_localctx).expr.code;
				      ((ArgsContext)_localctx).size =  1;
				      if(((ArgsContext)_localctx).expr.type.equals("float"))
				        _localctx.size++;
				    
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(288);
					match(T__14);
					setState(289);
					((ArgsContext)_localctx).expr = expr(0);

					      _localctx.code += ((ArgsContext)_localctx).expr.code;
					      _localctx.size += 1;
					      if(((ArgsContext)_localctx).expr.type.equals("float"))
					        _localctx.size++;
					    
					}
					}
					setState(296);
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
		public ExprContext expr;
		public Token BOOLEAN;
		public Token ENTIER;
		public Token e1;
		public Token e2;
		public Token IDENTIFIANT;
		public ArgsContext args;
		public Token TYPE;
		public Token op;
		public ExprContext b;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BOOLEAN() { return getToken(CalculetteParser.BOOLEAN, 0); }
		public List<TerminalNode> ENTIER() { return getTokens(CalculetteParser.ENTIER); }
		public TerminalNode ENTIER(int i) {
			return getToken(CalculetteParser.ENTIER, i);
		}
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode TYPE() { return getToken(CalculetteParser.TYPE, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitExpr(this);
		}
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
		((ExprContext)_localctx).code =  new String();
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(300);
				match(T__2);
				setState(301);
				((ExprContext)_localctx).a = ((ExprContext)_localctx).expr = expr(0);
				setState(302);
				match(T__3);
				((ExprContext)_localctx).code =  ((ExprContext)_localctx).a.code; ((ExprContext)_localctx).type =  ((ExprContext)_localctx).a.type;
				}
				break;
			case 2:
				{
				setState(305);
				((ExprContext)_localctx).BOOLEAN = match(BOOLEAN);

				      String val = (((ExprContext)_localctx).BOOLEAN!=null?((ExprContext)_localctx).BOOLEAN.getText():null).equals("false")? "0\n" : "1\n";
				      ((ExprContext)_localctx).code =  "PUSHI " + val;
				    
				}
				break;
			case 3:
				{
				setState(307);
				((ExprContext)_localctx).ENTIER = match(ENTIER);
				((ExprContext)_localctx).code =  "PUSHI "+(((ExprContext)_localctx).ENTIER!=null?((ExprContext)_localctx).ENTIER.getText():null)+"\n"; ((ExprContext)_localctx).type =  "int";
				}
				break;
			case 4:
				{
				setState(309);
				((ExprContext)_localctx).e1 = match(ENTIER);
				setState(310);
				match(T__19);
				setState(312);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(311);
					((ExprContext)_localctx).e2 = match(ENTIER);
					}
					break;
				}

				      ((ExprContext)_localctx).type = "float";
				      ((ExprContext)_localctx).code =  "PUSHF "+(((ExprContext)_localctx).e1!=null?((ExprContext)_localctx).e1.getText():null)+ ".";
				      if((((ExprContext)_localctx).e2!=null?((ExprContext)_localctx).e2.getText():null) == null)
				        _localctx.code += "0\n";
				      else
				        _localctx.code += (((ExprContext)_localctx).e2!=null?((ExprContext)_localctx).e2.getText():null) + "\n";
				    
				}
				break;
			case 5:
				{
				setState(315);
				((ExprContext)_localctx).ENTIER = match(ENTIER);
				setState(316);
				match(T__19);
				((ExprContext)_localctx).type =  "float"; ((ExprContext)_localctx).code =  "PUSHF " + (((ExprContext)_localctx).ENTIER!=null?((ExprContext)_localctx).ENTIER.getText():null) + ".0\n";
				}
				break;
			case 6:
				{
				setState(318);
				match(T__18);
				setState(319);
				((ExprContext)_localctx).ENTIER = match(ENTIER);
				((ExprContext)_localctx).code =  "PUSHI 0\nPUSHI " +(((ExprContext)_localctx).ENTIER!=null?((ExprContext)_localctx).ENTIER.getText():null) + "\nSUB\n"; ((ExprContext)_localctx).type =  "float";
				}
				break;
			case 7:
				{
				setState(321);
				match(T__18);
				setState(322);
				((ExprContext)_localctx).e1 = match(ENTIER);
				setState(323);
				match(T__19);
				setState(324);
				((ExprContext)_localctx).e2 = match(ENTIER);
				((ExprContext)_localctx).code =  "PUSHF 0.0\nPUSHF " + (((ExprContext)_localctx).e1!=null?((ExprContext)_localctx).e1.getText():null) + "." + (((ExprContext)_localctx).e2!=null?((ExprContext)_localctx).e2.getText():null) + "\nSUB\n"; ((ExprContext)_localctx).type = "float";
				}
				break;
			case 8:
				{
				setState(326);
				((ExprContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				        AdresseType at = tablesSymboles.getAdresseType((((ExprContext)_localctx).IDENTIFIANT!=null?((ExprContext)_localctx).IDENTIFIANT.getText():null));
				        ((ExprContext)_localctx).code =  posif("push", at);
				        ((ExprContext)_localctx).type =  at.type;
				        /*
				        String push = posif("push", adr);
				        ((ExprContext)_localctx).code =  push + adr +"\n";
				        adr++;
				        if(at.type.equals("float"))
				          ((ExprContext)_localctx).code =  push + adr +"\n";*/

				    
				}
				break;
			case 9:
				{
				setState(328);
				((ExprContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(329);
				match(T__2);
				setState(330);
				((ExprContext)_localctx).args = args();
				setState(331);
				match(T__3);

				        AdresseType at = tablesSymboles.getFunction((((ExprContext)_localctx).IDENTIFIANT!=null?((ExprContext)_localctx).IDENTIFIANT.getText():null));
				        ((ExprContext)_localctx).type =  at.type;

				        if(at.type.equals("float"))
				            ((ExprContext)_localctx).code =  "PUSHF 0.0\n";
				        else
				            ((ExprContext)_localctx).code =  "PUSHI 0\n";

				        _localctx.code += ((ExprContext)_localctx).args.code + "CALL "+at.adresse + "\n";
				        for(int i = 0; i < ((ExprContext)_localctx).args.size; i++)
				        {
				            _localctx.code+= "POP\n";
				        }
				    
				}
				break;
			case 10:
				{
				setState(334);
				match(T__2);
				setState(335);
				((ExprContext)_localctx).TYPE = match(TYPE);
				setState(336);
				match(T__3);
				setState(337);
				((ExprContext)_localctx).expr = expr(2);

				      ((ExprContext)_localctx).code =  ((ExprContext)_localctx).expr.code + "\n" + cast((((ExprContext)_localctx).TYPE!=null?((ExprContext)_localctx).TYPE.getText():null), ((ExprContext)_localctx).expr.type);
				    
				}
				break;
			case 11:
				{
				setState(340);
				((ExprContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);
				setState(341);
				match(T__20);

				      AdresseType at = tablesSymboles.getAdresseType((((ExprContext)_localctx).IDENTIFIANT!=null?((ExprContext)_localctx).IDENTIFIANT.getText():null));
				      ((ExprContext)_localctx).code =  posif("push", at);
				      if(at.type.equals("float")){
				        _localctx.code += "PUSHF 1.0 \nFADD \n";
				      }else if(at.type.equals("int")){
				        _localctx.code += "PUSHI 1 \nADD \n";
				      }
				      _localctx.code += posif("store", at);
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(357);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(355);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(345);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(346);
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
						setState(347);
						((ExprContext)_localctx).b = ((ExprContext)_localctx).expr = expr(13);
						((ExprContext)_localctx).type =  ((ExprContext)_localctx).a.type; ((ExprContext)_localctx).code =  evalexpr(((ExprContext)_localctx).a.code, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).b.code, _localctx.type);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.a = _prevctx;
						_localctx.a = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(350);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(351);
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
						setState(352);
						((ExprContext)_localctx).b = ((ExprContext)_localctx).expr = expr(12);
						((ExprContext)_localctx).type =  ((ExprContext)_localctx).a.type; ((ExprContext)_localctx).code =  evalexpr(((ExprContext)_localctx).a.code, (((ExprContext)_localctx).op!=null?((ExprContext)_localctx).op.getText():null), ((ExprContext)_localctx).b.code, _localctx.type);
						}
						break;
					}
					} 
				}
				setState(359);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		public Token BOOLEAN;
		public Token IDENTIFIANT;
		public Token ENTIER;
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
		public TerminalNode BOOLEAN() { return getToken(CalculetteParser.BOOLEAN, 0); }
		public TerminalNode IDENTIFIANT() { return getToken(CalculetteParser.IDENTIFIANT, 0); }
		public TerminalNode ENTIER() { return getToken(CalculetteParser.ENTIER, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CalculetteListener ) ((CalculetteListener)listener).exitCondition(this);
		}
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
			setState(376);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(361);
				((ConditionContext)_localctx).a = expr(0);
				setState(362);
				((ConditionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27))) != 0)) ) {
					((ConditionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(363);
				((ConditionContext)_localctx).b = expr(0);

				      ((ConditionContext)_localctx).code =  evalexpr(((ConditionContext)_localctx).a.code, (((ConditionContext)_localctx).op!=null?((ConditionContext)_localctx).op.getText():null), ((ConditionContext)_localctx).b.code, ((ConditionContext)_localctx).b.type);
				    
				}
				break;
			case 2:
				{
				setState(366);
				match(T__30);
				setState(367);
				((ConditionContext)_localctx).condition = condition(4);
				((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).condition.code + "PUSHI 1\nNEQ\n";
				}
				break;
			case 3:
				{
				setState(370);
				((ConditionContext)_localctx).BOOLEAN = match(BOOLEAN);

				      String val = (((ConditionContext)_localctx).BOOLEAN!=null?((ConditionContext)_localctx).BOOLEAN.getText():null).equals("false")? "0\n" : "1\n";
				      ((ConditionContext)_localctx).code =  "PUSHI " + val;
				    
				}
				break;
			case 4:
				{
				setState(372);
				((ConditionContext)_localctx).IDENTIFIANT = match(IDENTIFIANT);

				      AdresseType at = tablesSymboles.getAdresseType((((ConditionContext)_localctx).IDENTIFIANT!=null?((ConditionContext)_localctx).IDENTIFIANT.getText():null));
				      ((ConditionContext)_localctx).code =  posif("push", at);
				    
				}
				break;
			case 5:
				{
				setState(374);
				((ConditionContext)_localctx).ENTIER = match(ENTIER);

				      ((ConditionContext)_localctx).code =  "PUSH " + (((ConditionContext)_localctx).ENTIER!=null?((ConditionContext)_localctx).ENTIER.getText():null) + "\n";
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(390);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(388);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.c1 = _prevctx;
						_localctx.c1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(378);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(379);
						match(T__28);
						setState(380);
						((ConditionContext)_localctx).c2 = ((ConditionContext)_localctx).condition = condition(7);

						                  ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).c1.code + ((ConditionContext)_localctx).c2.code + "MUL\n";
						              
						}
						break;
					case 2:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						_localctx.c1 = _prevctx;
						_localctx.c1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(383);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(384);
						match(T__29);
						setState(385);
						((ConditionContext)_localctx).c2 = ((ConditionContext)_localctx).condition = condition(6);

						                  ((ConditionContext)_localctx).code =  ((ConditionContext)_localctx).c1.code + ((ConditionContext)_localctx).c2.code + "ADD\n";
						              
						}
						break;
					}
					} 
				}
				setState(392);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u018c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\3\3\3\3\3\7\3%\n"+
		"\3\f\3\16\3(\13\3\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\3\3\3\3\3\7\3\64\n"+
		"\3\f\3\16\3\67\13\3\7\39\n\3\f\3\16\3<\13\3\3\3\7\3?\n\3\f\3\16\3B\13"+
		"\3\3\3\3\3\3\3\3\3\7\3H\n\3\f\3\16\3K\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4[\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5{\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5\u008c\n\5\3\5\3\5\5\5\u0090\n\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5\u009b\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\5\5\u00a9\n\5\3\5\3\5\3\5\3\5\3\5\5\5\u00b0\n\5\3\5\3\5\5"+
		"\5\u00b4\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5\u00c9\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00d1\n\6"+
		"\3\7\3\7\3\7\3\7\3\7\5\7\u00d8\n\7\3\7\3\7\3\7\3\7\5\7\u00de\n\7\3\7\3"+
		"\7\3\7\3\7\5\7\u00e4\n\7\3\7\3\7\3\7\5\7\u00e9\n\7\3\b\3\b\3\b\3\b\7\b"+
		"\u00ef\n\b\f\b\16\b\u00f2\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\6\n\u00fc"+
		"\n\n\r\n\16\n\u00fd\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0113\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\7\f\u011c\n\f\f\f\16\f\u011f\13\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\7\r\u0127\n\r\f\r\16\r\u012a\13\r\5\r\u012c\n\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u013b\n\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u015a\n\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16"+
		"\u0166\n\16\f\16\16\16\u0169\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u017b\n\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0187\n\17\f\17\16\17\u018a"+
		"\13\17\3\17\2\4\32\34\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\6\4\2\f"+
		"\f))\3\2\22\23\3\2\24\25\3\2\30\36\2\u01b7\2\36\3\2\2\2\4&\3\2\2\2\6Z"+
		"\3\2\2\2\b\u00c8\3\2\2\2\n\u00d0\3\2\2\2\f\u00e8\3\2\2\2\16\u00ea\3\2"+
		"\2\2\20\u00f5\3\2\2\2\22\u00fb\3\2\2\2\24\u0112\3\2\2\2\26\u0114\3\2\2"+
		"\2\30\u012b\3\2\2\2\32\u0159\3\2\2\2\34\u017a\3\2\2\2\36\37\5\4\3\2\37"+
		" \7\2\2\3 \3\3\2\2\2!\"\5\6\4\2\"#\b\3\1\2#%\3\2\2\2$!\3\2\2\2%(\3\2\2"+
		"\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2\2(&\3\2\2\2)-\b\3\1\2*,\7)\2\2+*\3\2"+
		"\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.:\3\2\2\2/-\3\2\2\2\60\61\5\24\13\2"+
		"\61\65\b\3\1\2\62\64\7)\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2"+
		"\65\66\3\2\2\2\669\3\2\2\2\67\65\3\2\2\28\60\3\2\2\29<\3\2\2\2:8\3\2\2"+
		"\2:;\3\2\2\2;@\3\2\2\2<:\3\2\2\2=?\7)\2\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2"+
		"\2@A\3\2\2\2AC\3\2\2\2B@\3\2\2\2CI\b\3\1\2DE\5\b\5\2EF\b\3\1\2FH\3\2\2"+
		"\2GD\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\b\3\1"+
		"\2M\5\3\2\2\2NO\7\'\2\2OP\7(\2\2PQ\5\22\n\2QR\b\4\1\2R[\3\2\2\2ST\7\'"+
		"\2\2TU\7(\2\2UV\7\3\2\2VW\5\32\16\2WX\5\22\n\2XY\b\4\1\2Y[\3\2\2\2ZN\3"+
		"\2\2\2ZS\3\2\2\2[\7\3\2\2\2\\]\5\32\16\2]^\5\22\n\2^_\b\5\1\2_\u00c9\3"+
		"\2\2\2`a\5\20\t\2ab\5\22\n\2bc\b\5\1\2c\u00c9\3\2\2\2de\5\22\n\2ef\b\5"+
		"\1\2f\u00c9\3\2\2\2gh\7\4\2\2hi\7\5\2\2ij\5\32\16\2jk\7\6\2\2kl\5\22\n"+
		"\2lm\b\5\1\2m\u00c9\3\2\2\2no\7\7\2\2op\7\5\2\2pq\7(\2\2qr\7\6\2\2rs\5"+
		"\22\n\2st\b\5\1\2t\u00c9\3\2\2\2uv\7\b\2\2vw\7\5\2\2wx\5\34\17\2xz\7\6"+
		"\2\2y{\7)\2\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\5\16\b\2}~\b\5\1\2~\u00c9"+
		"\3\2\2\2\177\u0080\7\b\2\2\u0080\u0081\7\5\2\2\u0081\u0082\5\34\17\2\u0082"+
		"\u0083\7\6\2\2\u0083\u0084\5\b\5\2\u0084\u0085\b\5\1\2\u0085\u00c9\3\2"+
		"\2\2\u0086\u0087\7\t\2\2\u0087\u0088\7\5\2\2\u0088\u0089\5\34\17\2\u0089"+
		"\u008b\7\6\2\2\u008a\u008c\7)\2\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2"+
		"\2\2\u008c\u008d\3\2\2\2\u008d\u008f\5\n\6\2\u008e\u0090\7)\2\2\u008f"+
		"\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\7\n"+
		"\2\2\u0092\u0093\5\f\7\2\u0093\u0094\b\5\1\2\u0094\u00c9\3\2\2\2\u0095"+
		"\u0096\7\t\2\2\u0096\u0097\7\5\2\2\u0097\u0098\5\34\17\2\u0098\u009a\7"+
		"\6\2\2\u0099\u009b\7)\2\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009d\5\n\6\2\u009d\u009e\b\5\1\2\u009e\u00c9\3\2"+
		"\2\2\u009f\u00a0\7\13\2\2\u00a0\u00a1\7\5\2\2\u00a1\u00a2\5\20\t\2\u00a2"+
		"\u00a3\7\f\2\2\u00a3\u00a4\5\34\17\2\u00a4\u00a5\7\f\2\2\u00a5\u00a6\5"+
		"\20\t\2\u00a6\u00a8\7\6\2\2\u00a7\u00a9\7)\2\2\u00a8\u00a7\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\5\n\6\2\u00ab\u00ac\b\5"+
		"\1\2\u00ac\u00c9\3\2\2\2\u00ad\u00af\7\r\2\2\u00ae\u00b0\7)\2\2\u00af"+
		"\u00ae\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\5\16"+
		"\b\2\u00b2\u00b4\7)\2\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b6\7\16\2\2\u00b6\u00b7\7\5\2\2\u00b7\u00b8\5"+
		"\34\17\2\u00b8\u00b9\7\6\2\2\u00b9\u00ba\b\5\1\2\u00ba\u00c9\3\2\2\2\u00bb"+
		"\u00bc\7&\2\2\u00bc\u00bd\5\32\16\2\u00bd\u00be\5\22\n\2\u00be\u00bf\b"+
		"\5\1\2\u00bf\u00c9\3\2\2\2\u00c0\u00c1\7#\2\2\u00c1\u00c2\5\22\n\2\u00c2"+
		"\u00c3\b\5\1\2\u00c3\u00c9\3\2\2\2\u00c4\u00c5\7$\2\2\u00c5\u00c6\5\22"+
		"\n\2\u00c6\u00c7\b\5\1\2\u00c7\u00c9\3\2\2\2\u00c8\\\3\2\2\2\u00c8`\3"+
		"\2\2\2\u00c8d\3\2\2\2\u00c8g\3\2\2\2\u00c8n\3\2\2\2\u00c8u\3\2\2\2\u00c8"+
		"\177\3\2\2\2\u00c8\u0086\3\2\2\2\u00c8\u0095\3\2\2\2\u00c8\u009f\3\2\2"+
		"\2\u00c8\u00ad\3\2\2\2\u00c8\u00bb\3\2\2\2\u00c8\u00c0\3\2\2\2\u00c8\u00c4"+
		"\3\2\2\2\u00c9\t\3\2\2\2\u00ca\u00cb\5\b\5\2\u00cb\u00cc\b\6\1\2\u00cc"+
		"\u00d1\3\2\2\2\u00cd\u00ce\5\16\b\2\u00ce\u00cf\b\6\1\2\u00cf\u00d1\3"+
		"\2\2\2\u00d0\u00ca\3\2\2\2\u00d0\u00cd\3\2\2\2\u00d1\13\3\2\2\2\u00d2"+
		"\u00d3\7\t\2\2\u00d3\u00d4\7\5\2\2\u00d4\u00d5\5\34\17\2\u00d5\u00d7\7"+
		"\6\2\2\u00d6\u00d8\7)\2\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9\u00da\5\n\6\2\u00da\u00db\b\7\1\2\u00db\u00e9\3\2"+
		"\2\2\u00dc\u00de\7)\2\2\u00dd\u00dc\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e0\5\16\b\2\u00e0\u00e1\b\7\1\2\u00e1\u00e9\3"+
		"\2\2\2\u00e2\u00e4\7)\2\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		"\u00e5\3\2\2\2\u00e5\u00e6\5\b\5\2\u00e6\u00e7\b\7\1\2\u00e7\u00e9\3\2"+
		"\2\2\u00e8\u00d2\3\2\2\2\u00e8\u00dd\3\2\2\2\u00e8\u00e3\3\2\2\2\u00e9"+
		"\r\3\2\2\2\u00ea\u00f0\7\17\2\2\u00eb\u00ec\5\b\5\2\u00ec\u00ed\b\b\1"+
		"\2\u00ed\u00ef\3\2\2\2\u00ee\u00eb\3\2\2\2\u00ef\u00f2\3\2\2\2\u00f0\u00ee"+
		"\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f3"+
		"\u00f4\7\20\2\2\u00f4\17\3\2\2\2\u00f5\u00f6\7(\2\2\u00f6\u00f7\7\3\2"+
		"\2\u00f7\u00f8\5\32\16\2\u00f8\u00f9\b\t\1\2\u00f9\21\3\2\2\2\u00fa\u00fc"+
		"\t\2\2\2\u00fb\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\23\3\2\2\2\u00ff\u0100\7\'\2\2\u0100\u0101\7(\2\2"+
		"\u0101\u0102\b\13\1\2\u0102\u0103\7\5\2\2\u0103\u0104\5\26\f\2\u0104\u0105"+
		"\7\6\2\2\u0105\u0106\b\13\1\2\u0106\u0107\5\16\b\2\u0107\u0108\b\13\1"+
		"\2\u0108\u0113\3\2\2\2\u0109\u010a\7\'\2\2\u010a\u010b\7(\2\2\u010b\u010c"+
		"\b\13\1\2\u010c\u010d\7\5\2\2\u010d\u010e\7\6\2\2\u010e\u010f\b\13\1\2"+
		"\u010f\u0110\5\16\b\2\u0110\u0111\b\13\1\2\u0111\u0113\3\2\2\2\u0112\u00ff"+
		"\3\2\2\2\u0112\u0109\3\2\2\2\u0113\25\3\2\2\2\u0114\u0115\7\'\2\2\u0115"+
		"\u0116\7(\2\2\u0116\u011d\b\f\1\2\u0117\u0118\7\21\2\2\u0118\u0119\7\'"+
		"\2\2\u0119\u011a\7(\2\2\u011a\u011c\b\f\1\2\u011b\u0117\3\2\2\2\u011c"+
		"\u011f\3\2\2\2\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\27\3\2\2"+
		"\2\u011f\u011d\3\2\2\2\u0120\u0121\5\32\16\2\u0121\u0128\b\r\1\2\u0122"+
		"\u0123\7\21\2\2\u0123\u0124\5\32\16\2\u0124\u0125\b\r\1\2\u0125\u0127"+
		"\3\2\2\2\u0126\u0122\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u0120\3\2"+
		"\2\2\u012b\u012c\3\2\2\2\u012c\31\3\2\2\2\u012d\u012e\b\16\1\2\u012e\u012f"+
		"\7\5\2\2\u012f\u0130\5\32\16\2\u0130\u0131\7\6\2\2\u0131\u0132\b\16\1"+
		"\2\u0132\u015a\3\2\2\2\u0133\u0134\7%\2\2\u0134\u015a\b\16\1\2\u0135\u0136"+
		"\7+\2\2\u0136\u015a\b\16\1\2\u0137\u0138\7+\2\2\u0138\u013a\7\26\2\2\u0139"+
		"\u013b\7+\2\2\u013a\u0139\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\3\2"+
		"\2\2\u013c\u015a\b\16\1\2\u013d\u013e\7+\2\2\u013e\u013f\7\26\2\2\u013f"+
		"\u015a\b\16\1\2\u0140\u0141\7\25\2\2\u0141\u0142\7+\2\2\u0142\u015a\b"+
		"\16\1\2\u0143\u0144\7\25\2\2\u0144\u0145\7+\2\2\u0145\u0146\7\26\2\2\u0146"+
		"\u0147\7+\2\2\u0147\u015a\b\16\1\2\u0148\u0149\7(\2\2\u0149\u015a\b\16"+
		"\1\2\u014a\u014b\7(\2\2\u014b\u014c\7\5\2\2\u014c\u014d\5\30\r\2\u014d"+
		"\u014e\7\6\2\2\u014e\u014f\b\16\1\2\u014f\u015a\3\2\2\2\u0150\u0151\7"+
		"\5\2\2\u0151\u0152\7\'\2\2\u0152\u0153\7\6\2\2\u0153\u0154\5\32\16\4\u0154"+
		"\u0155\b\16\1\2\u0155\u015a\3\2\2\2\u0156\u0157\7(\2\2\u0157\u0158\7\27"+
		"\2\2\u0158\u015a\b\16\1\2\u0159\u012d\3\2\2\2\u0159\u0133\3\2\2\2\u0159"+
		"\u0135\3\2\2\2\u0159\u0137\3\2\2\2\u0159\u013d\3\2\2\2\u0159\u0140\3\2"+
		"\2\2\u0159\u0143\3\2\2\2\u0159\u0148\3\2\2\2\u0159\u014a\3\2\2\2\u0159"+
		"\u0150\3\2\2\2\u0159\u0156\3\2\2\2\u015a\u0167\3\2\2\2\u015b\u015c\f\16"+
		"\2\2\u015c\u015d\t\3\2\2\u015d\u015e\5\32\16\17\u015e\u015f\b\16\1\2\u015f"+
		"\u0166\3\2\2\2\u0160\u0161\f\r\2\2\u0161\u0162\t\4\2\2\u0162\u0163\5\32"+
		"\16\16\u0163\u0164\b\16\1\2\u0164\u0166\3\2\2\2\u0165\u015b\3\2\2\2\u0165"+
		"\u0160\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2"+
		"\2\2\u0168\33\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016b\b\17\1\2\u016b\u016c"+
		"\5\32\16\2\u016c\u016d\t\5\2\2\u016d\u016e\5\32\16\2\u016e\u016f\b\17"+
		"\1\2\u016f\u017b\3\2\2\2\u0170\u0171\7!\2\2\u0171\u0172\5\34\17\6\u0172"+
		"\u0173\b\17\1\2\u0173\u017b\3\2\2\2\u0174\u0175\7%\2\2\u0175\u017b\b\17"+
		"\1\2\u0176\u0177\7(\2\2\u0177\u017b\b\17\1\2\u0178\u0179\7+\2\2\u0179"+
		"\u017b\b\17\1\2\u017a\u016a\3\2\2\2\u017a\u0170\3\2\2\2\u017a\u0174\3"+
		"\2\2\2\u017a\u0176\3\2\2\2\u017a\u0178\3\2\2\2\u017b\u0188\3\2\2\2\u017c"+
		"\u017d\f\b\2\2\u017d\u017e\7\37\2\2\u017e\u017f\5\34\17\t\u017f\u0180"+
		"\b\17\1\2\u0180\u0187\3\2\2\2\u0181\u0182\f\7\2\2\u0182\u0183\7 \2\2\u0183"+
		"\u0184\5\34\17\b\u0184\u0185\b\17\1\2\u0185\u0187\3\2\2\2\u0186\u017c"+
		"\3\2\2\2\u0186\u0181\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0186\3\2\2\2\u0188"+
		"\u0189\3\2\2\2\u0189\35\3\2\2\2\u018a\u0188\3\2\2\2#&-\65:@IZz\u008b\u008f"+
		"\u009a\u00a8\u00af\u00b3\u00c8\u00d0\u00d7\u00dd\u00e3\u00e8\u00f0\u00fd"+
		"\u0112\u011d\u0128\u012b\u013a\u0159\u0165\u0167\u017a\u0186\u0188";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
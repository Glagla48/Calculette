grammar Calculette;

@parser::members {
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

}


start
    : calcul EOF
    ;

calcul returns [ String code ] // modifie TP7
@init{ $code = new String(); }   // On initialise $code, pour ensuite l'utiliser comme accumulateur
@after{ System.out.println($code); }
    :   (decl { $code += $decl.code; })*
        { int entry = nextLabel(); $code += "  JUMP " + entry + "\n"; }
        NEWLINE*

        (fonction { $code += $fonction.code; } NEWLINE*)*
        NEWLINE*

        { $code += "LABEL " + entry + "\n"; }
        (instruction { $code += $instruction.code; })*

        { $code += "  HALT\n"; }
    ;

decl returns [ String code ]
    :TYPE IDENTIFIANT finInstruction
        {
          tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);

          if($TYPE.text.equals("float"))
            $code = "PUSHF 0.0\n";
          else
            $code = "PUSHI 0\n";
        }
    | TYPE IDENTIFIANT '=' expr finInstruction
    {
        tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
        AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
        String store = posif("store", at);

        $expr.type = $TYPE.text;
        if($TYPE.text.equals("float"))
        {
          $code = "PUSHF 0.0\n" + $expr.code + "\n" + store;
        }
        else
          $code ="PUSHI 0\n" + $expr.code + "\n" + store;
    }
    ;

instruction returns [ String code]
    : expr finInstruction
        {
            $code  = $expr.code;
        }
    | assignation finInstruction
        {
            $code = $assignation.code;
        }
    | finInstruction
        {
            $code="";
        }

    | 'write' '(' expr ')' finInstruction// write -> jprend une expr pushg write + pop   read ID -> READ (demande un entier)  et puis le storeg
    {
        String write  = $expr.type.equals("float") ? "WRITEF\nPOP\nPOP\n" : "WRITE\nPOP\n";
        $code = $expr.code + write;
    }
    | 'read' '(' IDENTIFIANT ')' finInstruction
    {
        AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
        String store = posif("store", at);
        String read = at.type.equals("float") ? "READF\n" : "READ\n";
        $code = read + store;
    }
    | 'while' '(' condition ')' NEWLINE? bloc
    {
        int labelA = nextLabel();
        label_continue = _cur_label;
        int labelB = nextLabel();
        label_break  = _cur_label;
        $code = "LABEL " + labelA + "\n" + $condition.code + "JUMPF " + labelB + "\n" + $bloc.code + "JUMP " + labelA + "\n" +"LABEL " + labelB + "\n";
    }
    | 'while' '(' condition ')' instruction
    {
      int labelA = nextLabel();
      label_continue = _cur_label;
      int labelB = nextLabel();
      label_break  = _cur_label;

        $code = "LABEL " + labelA + "\n" + $condition.code + "JUMPF " + labelB + "\n" + $instruction.code + "JUMP " + labelA + "\n" + "LABEL " + labelB + "\n";
    }
    | 'if' '(' condition ')' NEWLINE? instructionthen NEWLINE? 'else' instructionelse
    {
      int l1 = nextLabel();
      int l2 = nextLabel();
      label_continue = l2;
      $code = $condition.code + "JUMPF " + l1 + "\n" + $instructionthen.code + "JUMP " + l2 + "\n"
      + "LABEL " + l1 + "\n" + $instructionelse.code + "LABEL " + l2 + "\n";
    }
    | 'if' '(' condition ')' NEWLINE? instructionthen
    {
      int l1 = nextLabel();
      label_continue = l1;
      $code = $condition.code + "JUMPF " + l1 + "\n" + $instructionthen.code + "LABEL " + l1 + "\n";
    }
    | 'for' '(' a1=assignation ';' condition ';' a2=assignation ')'NEWLINE? instructionthen
    {
      int l1 = nextLabel();
      int l2 = nextLabel();
      label_continue = l1;
      label_break = l2;
      $code = $a1.code + "LABEL " + l1 + "\n" + $condition.code + "JUMPF " + l2
      + "\n"  + $instructionthen.code + $a2.code + "JUMP " + l1 +"\n"+ "LABEL " + l2 + "\n";
    }
    | 'repeat' NEWLINE? bloc NEWLINE? 'until' '(' condition ')'
    {
        int labelA = nextLabel();

        $code = "LABEL " + labelA + "\n" +
            $bloc.code +
            $condition.code +
            "JUMPF " + labelA + "\n";
    }
    | RETURN expr finInstruction
    {
        int adr = tablesSymboles.getAdresseType("return").adresse;
        int adr2 = adr + 1;

        if($expr.type.equals("float"))
        {
          $code = $expr.code + "STOREL "+ adr2 + "\n";
          $code += "STOREL "+ adr + "\n";
        }
        else{
          $code = $expr.code + "STOREL "+ adr + "\n";
        }
        $code += "RETURN\n";
    }
    | BREAK finInstruction
    {
      label_break = label_break + 2;
      $code = "JUMP " + label_break +"\n";
    }
    | CONTINUE finInstruction
    {
      label_continue = label_continue + 1;
      $code = "JUMP " +  label_continue +"\n";
    }
    ;

instructionthen returns [String code]
    : instruction {$code = $instruction.code;}
    | bloc {$code = $bloc.code;}
    ;

instructionelse returns [String code]
    : 'if' '(' condition ')' NEWLINE? instructionthen
    {
        $code = $condition.code + "JUMPF " + nextLabel() + "\n" + $instructionthen.code + "LABEL " + _cur_label + "\n";
    }
    | NEWLINE? bloc
    {
        $code = $bloc.code;
    }
    | NEWLINE? instruction
    {
        $code = $instruction.code;
    }
    ;


bloc returns [String code]
@init{$code = new String();}
    : '{' (instruction {$code += $instruction.code;})* '}'
    ;


assignation returns [ String code ]
    : IDENTIFIANT '=' expr
        {
            AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);

            String store = posif("store", at);
            $code = $expr.code + store;
        }
    ;

finInstruction : ( NEWLINE | ';' )+ ;



//------ TP 7 ------//
fonction returns [String code]
@init{tablesSymboles.newTableLocale();}
@after{tablesSymboles.dropTableLocale();}
    : TYPE IDENTIFIANT {tablesSymboles.putVar("return", $TYPE.text);} '('  params ')'
        {
            int l = nextLabel();
            tablesSymboles.newFunction($IDENTIFIANT.text, l, $TYPE.text);
            $code = "LABEL "+ l + "\n";
            $code += $params.code;
            // truc à faire par rapport au code += "LABEL " + entry + "\n"; }

        }
        bloc
        {
            $code += $bloc.code;
            $code += "RETURN\n";
        }

    | TYPE IDENTIFIANT {tablesSymboles.putVar("return", $TYPE.text);} '(' ')'
        {
            int l = nextLabel();
            tablesSymboles.newFunction($IDENTIFIANT.text, l, $TYPE.text);
            $code = "LABEL "+ l + "\n";
            // truc à faire par rapport au code += "LABEL " + entry + "\n"; }

        }
        bloc
        {
            $code += $bloc.code;
            $code += "RETURN\n";
        }
    ;

params returns [String code]
    : TYPE IDENTIFIANT
        {
            tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
            $code = "";
        }
        ( ',' TYPE IDENTIFIANT
            {
              tablesSymboles.putVar($IDENTIFIANT.text, $TYPE.text);
                // code java gérant une variable locale (argi)
            }
        )*
    ;

 // init nécessaire à cause du ? final et donc args peut être vide (mais $args sera non null)
args returns [ String code, int size]
@init{ $code = new String(); $size = 0; }
    : ( expr
    {
      $code += $expr.code;
      $size = 1;
      if($expr.type.equals("float"))
        $size++;
    }
    ( ',' expr
    {
      $code += $expr.code;
      $size += 1;
      if($expr.type.equals("float"))
        $size++;
    }
    )*
      )?
    ;


//------ TP 7 end------//a


expr returns [String code, String type]
@init{$code = new String();}
    : '(' a=expr ')' {$code = $a.code; $type = $a.type;}
    | a=expr op=('*'|'/') b=expr {$type = $a.type; $code = evalexpr($a.code, $op.text, $b.code, $type);}
    | a=expr op=('+'|'-') b=expr {$type = $a.type; $code = evalexpr($a.code, $op.text, $b.code, $type);}
    | BOOLEAN
    {
      String val = $BOOLEAN.text.equals("false")? "0\n" : "1\n";
      $code = "PUSHI " + val;
    }
    | ENTIER {$code = "PUSHI "+$ENTIER.text+"\n"; $type = "int";}
    | e1=ENTIER '.' e2=ENTIER?
    {
      $type="float";
      $code = "PUSHF "+$e1.text+ ".";
      if($e2.text == null)
        $code += "0\n";
      else
        $code += $e2.text + "\n";
    }
    | ENTIER '.' {$type = "float"; $code = "PUSHF " + $ENTIER.text + ".0\n";}
    | '-' ENTIER {$code = "PUSHI 0\nPUSHI " +$ENTIER.text + "\nSUB\n"; $type = "float";}
    | '-' e1=ENTIER '.' e2=ENTIER {$code = "PUSHF 0.0\nPUSHF " + $e1.text + "." + $e2.text + "\nSUB\n"; $type="float";}
    | IDENTIFIANT
    {
        AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
        $code = posif("push", at);
        $type = at.type;
        /*
        String push = posif("push", adr);
        $code = push + adr +"\n";
        adr++;
        if(at.type.equals("float"))
          $code = push + adr +"\n";*/

    }
    | IDENTIFIANT '(' args ')'
    {
        AdresseType at = tablesSymboles.getFunction($IDENTIFIANT.text);
        $type = at.type;

        if(at.type.equals("float"))
            $code = "PUSHF 0.0\n";
        else
            $code = "PUSHI 0\n";

        $code += $args.code + "CALL "+at.adresse + "\n";
        for(int i = 0; i < $args.size; i++)
        {
            $code+= "POP\n";
        }
    }
    | '(' TYPE ')' expr
    {
      $code = $expr.code + "\n" + cast($TYPE.text, $expr.type);
    }
    | IDENTIFIANT '++'
    {
      AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
      $code = posif("push", at);
      if(at.type.equals("float")){
        $code += "PUSHF 1.0 \nFADD \n";
      }else if(at.type.equals("int")){
        $code += "PUSHI 1 \nADD \n";
      }
      $code += posif("store", at);
    }
    ;

condition returns [String code]
    : a=expr op=('<'|'<='|'=='|'!='|'>'|'>=' |'<>') b=expr
    {
      $code = evalexpr($a.code, $op.text, $b.code, $b.type);
    }
    | c1=condition '&&' c2=condition
    {
        $code = $c1.code + $c2.code + "MUL\n";
    }
    | c1=condition '||' c2=condition
    {
        $code = $c1.code + $c2.code + "ADD\n";
    }
    | '!' condition {$code = $condition.code + "PUSHI 1\nNEQ\n";}
    | BOOLEAN
    {
      String val = $BOOLEAN.text.equals("false")? "0\n" : "1\n";
      $code = "PUSHI " + val;
    }
    | IDENTIFIANT
    {
      AdresseType at = tablesSymboles.getAdresseType($IDENTIFIANT.text);
      $code = posif("push", at);
    }
    | ENTIER
    {
      $code = "PUSH " + $ENTIER.text + "\n";
    }
    ;

// lexer

COMMENT : ('//' .+? NEWLINE |'/*' .+? '*/' | '#' .+? NEWLINE )->skip;


// TODO: Faire conitinue et break

BREAK :'break';

CONTINUE :'continue';

BOOLEAN : 'false' | 'true';

RETURN: 'return';

TYPE : 'int' | 'float' | 'bool';

IDENTIFIANT: ('a'..'z'| 'A'..'Z' )+ ('a'..'z'| 'A'..'Z' | '_' | '0'..'9')*;

NEWLINE : '\r'? '\n' ;

WS :   (' '|'\t')+ -> skip  ;

ENTIER : ('0'..'9')+ ;

UNMATCH : . -> skip ;

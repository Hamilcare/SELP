grammar Calc;

// syntactic rules

program  : function* body
         ;
function : '(' 'defun' head body ')'
         ;
head     : '(' functionId variableId* ')'
         ;
body     : varDef* expression
         ;
varDef :  variableId '=' expression
       ;

expression : '!' expression # UnaryExpression
          |  '-' expression # UnaryExpression
          |  expression OPMultiplicative expression # BinaryExpression
          |  expression OPAdditive expression # BinaryExpression
          |  expression '-' expression # BinaryExpression
          |  expression OPRelational expression # BinaryExpression
          |  expression OPEquality expression # BinaryExpression
          |  expression '&&' expression # BinaryExpression
          |  expression '||' expression # BinaryExpression
          |  <assoc = right>  expression '?' expression ':' expression # ConditionalExpression
          |  '(' expression ')' # ParExpression
          |  BOOLEAN #Boolean
          |  LITERAL #Literal
          ;

variableId : IDENTIFIER
           ;
functionId : IDENTIFIER
           ;

// lexical rules

OPAdditive : '+'
         ;

OPMultiplicative : '*' | '/'
              ;

OPRelational : '<' | '>' | '<=' | '>='
              ;

OPEquality : '==' | '!='
           ;

OPLogicalAND : '&&'
             ;

OPLogicalOR : '||'
            ;

BOOLEAN : 'true' | 'false';

IDENTIFIER : ('a'..'z')('a'..'z' | '0'..'9')*
         ;
LITERAL  : '0' | ('1'..'9')('0'..'9')*              
         ;
WS : [ \t\n\r]+ -> channel(HIDDEN) ;
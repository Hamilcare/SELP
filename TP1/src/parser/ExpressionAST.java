package parser;

import lexer.*;
import parser.exception.SyntaxErrorException;
import parser.exception.UnknownOperatorException;
import parser.exception.VariableUndefinedException;

public abstract class ExpressionAST extends AST{

    public abstract int eval() throws UnknownOperatorException, VariableUndefinedException;


    public static ExpressionAST parse (Token t, boolean alreadyCheckByBody) throws Exception {
        if(t instanceof LPar || alreadyCheckByBody ){
            Token t2;
            if(alreadyCheckByBody)
                 t2 = t;
            else
                 t2 = SLexer.getToken();
            //Unary minus
            if (t2 == OPToken.MINUS){
                ExpressionAST operande1 = ExpressionAST.parse(SLexer.getToken(),false);
                ExpressionAST rightOperande;
                Token last = SLexer.getToken();
                if(last instanceof RPar)
                    return  new UnaryExpressionAST(operande1);
                //BinaryMinus
                else if((rightOperande = ExpressionAST.parse(last,false)) instanceof ExpressionAST && (last = SLexer.getToken()) instanceof RPar){
                    return new BinaryExpressionAST(OPToken.MINUS,operande1,rightOperande);
                }
                else throw new SyntaxErrorException("Syntax Error Missing Right Parenthesis");
            }
            //BinaryExpression
            else if ( t2 instanceof OPToken){
                ExpressionAST leftOperande = ExpressionAST.parse(SLexer.getToken(),false);
                ExpressionAST rightOperande = ExpressionAST.parse(SLexer.getToken(),false);
                Token last = SLexer.getToken();
                if(last instanceof RPar)
                    return new BinaryExpressionAST((OPToken)t2,leftOperande,rightOperande);
                else throw new SyntaxErrorException("Syntax Error Missing Right Parenthesis");
            }
            //ConditionnalExpression
            else if( t2 instanceof If){
                ExpressionAST e1 = ExpressionAST.parse(SLexer.getToken(),false);
                ExpressionAST e2 = ExpressionAST.parse(SLexer.getToken(),false);
                ExpressionAST e3 = ExpressionAST.parse(SLexer.getToken(),false);
                Token last = SLexer.getToken();
                if(last instanceof RPar){
                    return new ConditionnalExpressionAST(e1,e2,e3);
                }else throw new SyntaxErrorException("Syntax Error Missing Right Parenthesis");
            }
        //Constante
        }else if( t instanceof LiteralToken) {
            return new LiteralAST(((LiteralToken) t).getValue());
        }
        //variable
        else if(t instanceof  Identifier){
            return new IdentifierAST(((Identifier)t).getValue());
        }

        else{
            throw new SyntaxErrorException(t);
        }
        return null;
    }

    @Override
    public String toString() {
        return "";
    }
}

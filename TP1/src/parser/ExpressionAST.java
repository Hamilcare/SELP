package parser;

import lexer.*;

import javax.swing.plaf.SliderUI;

public abstract class ExpressionAST extends AST{
    public static ExpressionAST parse (Token t) throws Exception {
        if(t instanceof LPar){
            Token t2 = SLexer.getToken();
            //Unary minus
            if (t2 == OPToken.MINUS){
                ExpressionAST operande1 = ExpressionAST.parse(SLexer.getToken());
                ExpressionAST rightOperande;
                Token last = SLexer.getToken();
                if(last instanceof RPar)
                    return  new UnaryExpressionAST(operande1);
                //BinaryMinus
                else if((rightOperande = ExpressionAST.parse(last)) instanceof ExpressionAST && (last = SLexer.getToken()) instanceof RPar){
                    return new BinaryExpressionAST(OPToken.MINUS,operande1,rightOperande);
                }
                else throw new Exception("Syntax Error Missing Right Parenthesis");
            }
            //BinaryExpression
            else if ( t2 instanceof OPToken){
                ExpressionAST leftOperande = ExpressionAST.parse(SLexer.getToken());
                ExpressionAST rightOperande = ExpressionAST.parse(SLexer.getToken());
                Token last = SLexer.getToken();
                if(last instanceof RPar)
                    return new BinaryExpressionAST((OPToken)t2,leftOperande,rightOperande);
                else throw new Exception("Syntax Error Missing Right Parenthesis");
            }
            //ConditionnalExpression
            else if( t2 instanceof If){
                ExpressionAST e1 = ExpressionAST.parse(SLexer.getToken());
                ExpressionAST e2 = ExpressionAST.parse(SLexer.getToken());
                ExpressionAST e3 = ExpressionAST.parse(SLexer.getToken());
                Token last = SLexer.getToken();
                if(last instanceof RPar){
                    return new ConditionnalExpressionAST(e1,e2,e3);
                }else throw new Exception("Syntax Error Missing Right Parenthesis");
            }
        //Constante
        }else if( t instanceof LiteralToken) {
            return new LiteralAST(((LiteralToken) t).getValue());
        }
        //variable
        else if(t instanceof  Identifier){
            return new VariableExpressionAST(((Identifier)t).getValue());
        }

        else{
            System.out.println("Error on " + t.getClass());
            System.out.println("Error on " + t);
            throw new Exception("Syntax Error");
        }
        return null;
    }

    @Override
    public String toString() {
        return null;
    }
}

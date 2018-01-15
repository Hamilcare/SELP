package parser;

import lexer.OPToken;

public class BinaryExpressionAST extends ExpressionAST {
    OPToken op;
    ExpressionAST rightOperande;
    ExpressionAST leftOperande;

    public BinaryExpressionAST(OPToken op,ExpressionAST le, ExpressionAST re){
        this.op = op;
        rightOperande = re;
        leftOperande = le;
    }
    @Override
    public String toString(){
        return "\nBinaryExpression("+op+", "+leftOperande+", "+rightOperande+")";
    }
}

package parser;

import lexer.OPToken;

import java.util.HashMap;

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
    public int eval(HashMap<String, Integer> bindings) throws Exception {
        int left = leftOperande.eval();
        int right = rightOperande.eval();

        switch (op) {
            case MINUS:
                return left - right;
            case PLUS:
                return left + right;
            case DIVIDE:
                return left/right;
            case TIMES:
                return left * right;
            case EQUAL:
                if(left==right)
                    return 1;
                else
                    return 0;
            case LESS:
                if(left < right)
                    return 1;
                else
                    return 0;

            default:
                throw  new Exception("Unknow operator");


        }
    }

    @Override
    public int eval() throws Exception{
        int left = leftOperande.eval();
        int right = rightOperande.eval();

        switch (op) {
            case MINUS:
                return left - right;
            case PLUS:
                return left + right;
            case DIVIDE:
                return left/right;
            case TIMES:
                return left * right;
            case EQUAL:
                if(left==right)
                    return 1;
                else
                    return 0;
            case LESS:
                if(left < right)
                    return 1;
                else
                    return 0;

            default:
                throw  new Exception("Unknow operator");


        }


    }

    @Override
    public String toString(){
        return "\nBinaryExpression("+op+", "+leftOperande+", "+rightOperande+")";
    }
}

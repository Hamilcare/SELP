package parser;

import parser.exception.UnknownOperatorException;
import parser.exception.VariableUndefinedException;

public class UnaryExpressionAST extends ExpressionAST {
    private ExpressionAST operande;

    public UnaryExpressionAST(ExpressionAST e){
        operande = e;
    }

    @Override
    public int eval() throws UnknownOperatorException, VariableUndefinedException {
        return -1 * operande.eval();
    }

    @Override
    public String toString(){
        return "UnaryExpression("+operande+")";
    }

}

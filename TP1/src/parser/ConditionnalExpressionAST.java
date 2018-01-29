package parser;

import parser.exception.UnknownOperatorException;
import parser.exception.VariableUndefinedException;

public class ConditionnalExpressionAST extends ExpressionAST {
    private ExpressionAST e1;
    private ExpressionAST e2;
    private ExpressionAST e3;

    public ConditionnalExpressionAST(ExpressionAST e1, ExpressionAST e2, ExpressionAST e3) {
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
    }


    @Override
    public int eval() throws UnknownOperatorException, VariableUndefinedException {
        if(e1.eval()!=0)
            return e2.eval();
        else
            return e3.eval();
    }

    @Override
    public String toString() {
        return "ConditionnalExpression("+e1+", "+e2+", "+e3+")";
    }
}

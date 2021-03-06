package parser;

public class ConditionnalExpressionAST extends ExpressionAST {
    public ExpressionAST e1, e2, e3;

    public ConditionnalExpressionAST(ExpressionAST e1, ExpressionAST e2, ExpressionAST e3) {
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
    }

    @Override
    public String toString() {
        return "ConditionnalExpression("+e1+", "+e2+", "+e3+")";
    }
}

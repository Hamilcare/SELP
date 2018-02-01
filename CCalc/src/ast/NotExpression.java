package ast;

public class NotExpression extends Expression {

    Expression expr;

    public NotExpression(Expression e){
        expr =e;
    }

    public int eval() throws Exception {
        return (-1) * expr.eval();
    }
}

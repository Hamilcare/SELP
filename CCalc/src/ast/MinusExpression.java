package ast;

public class MinusExpression extends Expression {
    private Expression operande;

    public MinusExpression(Expression e){
        operande = e;
    }

    @Override
    public int eval() throws Exception {
        return -1 * operande.eval();
    }


}
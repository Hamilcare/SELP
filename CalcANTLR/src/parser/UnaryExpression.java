package parser;

public class UnaryExpression extends Expression {
    private Expression operande;

    public UnaryExpression(Expression e){
        operande = e;
    }

    @Override
    public int eval() throws Exception {
        return -1 * operande.eval();
    }

    @Override
    public String toString(){
        return "UnaryExpression("+operande+")";
    }

}
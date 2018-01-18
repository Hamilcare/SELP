package parser;

public class UnaryExpressionAST extends ExpressionAST {
    ExpressionAST operande;

    public UnaryExpressionAST(ExpressionAST e){
        operande = e;
    }

    @Override
    public int eval() throws Exception{
        return -1 * operande.eval();
    }

    public String toString(){
        return "UnaryExpression("+operande+")";
    }

}

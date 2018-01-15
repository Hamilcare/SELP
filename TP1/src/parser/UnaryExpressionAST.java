package parser;

public class UnaryExpressionAST extends ExpressionAST {
    ExpressionAST operande;

    public UnaryExpressionAST(ExpressionAST e){
        operande = e;
    }

    public String toString(){
        return "UnaryExpression("+operande+")";
    }

}

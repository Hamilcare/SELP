package parser;

import java.util.HashMap;

public class UnaryExpressionAST extends ExpressionAST {
    ExpressionAST operande;

    public UnaryExpressionAST(ExpressionAST e){
        operande = e;
    }

    @Override
    public int eval() throws Exception{
        return -1 * operande.eval();
    }

    @Override
    public int eval(HashMap<String, Integer> bindings) throws Exception {
        return this.eval();
    }

    public String toString(){
        return "UnaryExpression("+operande+")";
    }

}

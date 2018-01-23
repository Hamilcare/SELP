package parser;

import java.util.HashMap;

public class LiteralAST extends ExpressionAST {

    int value;

    public LiteralAST(int v){
        value= v;
    }

    @Override
    public int eval() {
        return value;
    }

    @Override
    public int eval(HashMap<String, Integer> bindings) throws Exception {
        return this.eval();
    }

    @Override
    public String toString() {
        return "LiteralAST("+value+")";
    }
}

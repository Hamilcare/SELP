package parser;

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
    public String toString() {
        return "LiteralAST("+value+")";
    }
}

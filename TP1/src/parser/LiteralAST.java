package parser;

public class LiteralAST extends ExpressionAST {

    int value;

    public LiteralAST(int v){
        value= v;
    }

    @Override
    public String toString() {
        return "LiteralAST("+value+")";
    }
}

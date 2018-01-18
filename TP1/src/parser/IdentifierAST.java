package parser;

public class IdentifierAST extends ExpressionAST {

    String value;

    public IdentifierAST(String value) {
        this.value = value;
    }

    @Override
    public int eval() {
        return 0;
    }

    @Override
    public String toString(){
        return "\nVariable("+value+")";
    }
}

package parser;

public class VariableExpressionAST extends ExpressionAST {

    String value;

    public VariableExpressionAST(String value) {
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

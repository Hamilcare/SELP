package parser;

public class VariableExpressionAST extends ExpressionAST {

    String value;

    public VariableExpressionAST(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return "\nVariable("+value+")";
    }
}

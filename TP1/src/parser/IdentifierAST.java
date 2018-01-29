package parser;

import parser.exception.VariableUndefinedException;

public class IdentifierAST extends ExpressionAST {

    private String value;

    public IdentifierAST(String value) {
        this.value = value;
    }

    @Override
    public int eval() throws VariableUndefinedException {
        if(Body.getBindings().containsKey(this.getValue()))
            return Body.getBindings().get(this.getValue());
        else
            throw new VariableUndefinedException(this.getValue());
    }

    @Override
    public String toString(){
        return "\nVariable("+value+")";
    }

    public String getValue() {
        return value;
    }
}

package parser;

import java.util.HashMap;

public class IdentifierAST extends ExpressionAST {

    String value;

    public IdentifierAST(String value) {
        this.value = value;
    }

    @Override
    public int eval(HashMap<String,Integer> bindings) throws Exception {
        if(bindings.containsKey(this.getValue()))
            return bindings.get(this.getValue());
        else
            throw new Exception("Variable not defined : "+this.getValue());
    }

    @Override
    public int eval()throws Exception{
        //throw new Exception("Wrong evaluation of Identifier");
        if(Body.bindings.containsKey(this.getValue()))
            return Body.bindings.get(this.getValue());
        else
            throw new Exception("Variable not defined : "+this.getValue());
    }

    @Override
    public String toString(){
        return "\nVariable("+value+")";
    }

    public String getValue() {
        return value;
    }
}

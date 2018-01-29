package parser;

import java.util.HashMap;

public class Identifier extends AST {

    String value;

    public Identifier(String value) {
        this.value = value;
    }

    @Override
    public int eval()throws Exception{
        //throw new Exception("Wrong evaluation of Identifier");
        //if(Body.bindings.containsKey(this.getValue()))
        //    return Body.bindings.get(this.getValue());
        //else
        //    throw new Exception("Variable not defined : "+this.getValue());
        return 0;
    }

    @Override
    public String toString(){
        return "\nVariable("+value+")";
    }

    public String getValue() {
        return value;
    }
}

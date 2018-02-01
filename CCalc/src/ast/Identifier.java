package ast;



public class Identifier extends AST {

    String value;

    public Identifier(String value) {
        this.value = value;
    }

    /*@Override
    public int eval()throws Exception{
        //throw new Exception("Wrong evaluation of Identifier");
        //if(Body.bindings.containsKey(this.getValue()))
        //    return Body.bindings.get(this.getValue());
        //else
        //    throw new Exception("Variable not defined : "+this.getValue());
        return 0;
    }*/

    public String getValue() {
        return value;
    }

    @Override
    public String gen() {
        return null;
    }
}

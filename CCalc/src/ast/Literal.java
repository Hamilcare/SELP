package ast;

public class Literal extends Expression{
    int value;

    public Literal(int v){
        value= v;
    }

    @Override
    public int eval() {
        return value;
    }

    @Override
    public String gen(){
        return String.valueOf(value);
    }


}

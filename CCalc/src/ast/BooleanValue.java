package ast;

import ast.Exception.UnknownBooleanValueException;

public class BooleanValue extends Expression {

    static private final String FALSE = "false";

    static private final String TRUE = "true";

    int value;

    private BooleanValue(){}

    public BooleanValue(String s) {
        if (s.equals(FALSE)){
            this.value=0;
        }
        else if(s.equals(TRUE)){
            this.value = 1;
        }
        else{
            try {
                throw new UnknownBooleanValueException("Valeur boolean inconnue "+s);
            } catch (UnknownBooleanValueException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String gen(){
        return String.valueOf(value);
    }
}

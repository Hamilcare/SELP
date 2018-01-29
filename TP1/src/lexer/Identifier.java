package lexer;

public class Identifier implements Token {
    private String value;

    protected Identifier(String v){
        value = v;
    }

    public String getValue() {
        return value;
    }

    public String toString(){
        return "Identifier("+value+")";
    }
}

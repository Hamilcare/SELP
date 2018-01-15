package lexer;

public class Identifier implements Token {
    String value;

    public Identifier(String v){
        value = v;
    }

    public String getValue() {
        return value;
    }

    public String toString(){
        return "Identifier("+value+")";
    }
}

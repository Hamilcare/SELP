package lexer;

public class LiteralToken implements Token{
    private int value;

    LiteralToken(int v){
        value =v;
    }

    public int getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return "LiteralToken("+value+")";
    }

}

package parser.exception;

public class RightParenthesisExpectedException extends Exception{
    public RightParenthesisExpectedException(String s){
        super("ERROR, expected right parenthesis foud : "+s);
    }
}

package parser.exception;

import lexer.Token;

public class SyntaxErrorException extends Exception {
    public SyntaxErrorException(String s){
        super(s);
    }

    public SyntaxErrorException(Token t){
        super("Unexpected token "+t);
    }
}

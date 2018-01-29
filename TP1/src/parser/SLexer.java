package parser;

import lexer.Lexer;
import lexer.Token;
import lexer.UnexpectedCharacter;

import java.io.IOException;
import java.io.InputStream;


public class SLexer {
    private static Lexer lexer;


    private SLexer(){}

    public static void init(InputStream is) throws IOException {
            lexer = new Lexer(is);
    }

    public static Token getToken() throws IOException, UnexpectedCharacter {
            return lexer.getToken();
        }


}

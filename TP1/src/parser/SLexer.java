package parser;

import lexer.Lexer;
import lexer.Token;
import lexer.UnexpectedCharacter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SLexer {
    private static Lexer lexer;


    public static void init(InputStream is){
        try {
            lexer = new Lexer(is);
        }catch(Exception e) {
            System.out.println(e);
            System.exit(-1);
        }

    }

    public static Token getToken() {

        try {
            return lexer.getToken();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }
}

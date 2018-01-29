package calc;

import lexer.EOF;
import lexer.Token;

import parser.Body;
import parser.exception.ErrorEvaluationException;
import parser.exception.SyntaxErrorException;
import parser.SLexer;

import java.io.FileInputStream;
import java.io.InputStream;

import java.util.ArrayList;


public class Calc {

    public static void main(String[] args) throws Exception {

        String inputFile;
        InputStream is = System.in;
        if ( args.length>0 ) {

            inputFile = args[0];
            is = new FileInputStream(inputFile);
        }

            SLexer.init(is);
            Body arbre = Body.parse(SLexer.getToken(), new ArrayList<>());

        try {
            System.out.println(arbre.eval());
        }catch (Exception e){
            throw new ErrorEvaluationException(e.getMessage());
        }
            Token eof = SLexer.getToken();
            if(!(eof instanceof EOF)){
                throw new SyntaxErrorException("EOF Expected");
            }

    }
}

package calc;

import lexer.EOF;
import lexer.Lexer;
import lexer.Token;
import parser.AST;
import parser.Body;
import parser.ExpressionAST;
import parser.SLexer;

import javax.swing.plaf.SliderUI;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class TestParser {

    public static void main(String[] args) throws Exception {

        String inputFile = null;
        InputStream is = System.in;
        //System.out.println(args.length);
        if ( args.length>0 ) {

            inputFile = args[0];
            //System.out.println(inputFile);
            is = new FileInputStream(inputFile);
            //SLexer.init(is);


        }

//        try {
            SLexer.init(is);
            Body arbre = Body.parse(SLexer.getToken());
            System.out.println(arbre);
/*        try {
            System.out.println(arbre.eval());
        }catch (Exception e){
            throw new Exception("Erreur evaluation");
        }*/
            Token eof = SLexer.getToken();
            if(!(eof instanceof EOF)){
                throw new Exception("EOF Expected");
            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}

package calc;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

import lexer.*;
import parser.ExpressionAST;
import parser.SLexer;

public class TestLexer {

	/**
	 * @param args - arg[0] is the filename of the file to interpret
     *     (if it exists, otherwise the standard input stream is used).
	 */
	public static void main(String[] args) throws Exception {
		List<Token> tokens;
		String inputFile = null;
		InputStream is = System.in;
		//System.out.println(args.length);
		if ( args.length>0 ) {
			inputFile = args[0];
			System.out.println(inputFile);

			is = new FileInputStream(inputFile);
		}

		try {
			SLexer.init(is);
			ExpressionAST.parse(SLexer.getToken());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

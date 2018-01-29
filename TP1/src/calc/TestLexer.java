package calc;
import java.io.FileInputStream;
import java.io.InputStream;

import parser.ExpressionAST;
import parser.SLexer;

public class TestLexer {

	/**
	 * @param args - arg[0] is the filename of the file to interpret
     *     (if it exists, otherwise the standard input stream is used).
	 */
	public static void main(String[] args) throws Exception {

		String inputFile;
		InputStream is = System.in;

		if ( args.length>0 ) {
			inputFile = args[0];


			is = new FileInputStream(inputFile);
		}

		try {
			SLexer.init(is);
			ExpressionAST.parse(SLexer.getToken(),false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

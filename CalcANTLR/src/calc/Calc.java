package calc;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import parser.*;

import java.io.FileInputStream;
import java.io.InputStream;

public class Calc {
    // static boolean verbose = false;

    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if ( args.length>0 ) inputFile = args[0];
        // if (args.length>1 && args[1].equals("-v")) verbose = true;
        InputStream is = System.in;
        if ( inputFile!=null ) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);
        CalcLexer lexer = new CalcLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalcParser parser = new CalcParser(tokens);
        ParseTree tree = parser.program();
        System.out.println(tree.toStringTree(parser));
        ASTVisitor visitor = new ASTVisitor();
        AST ast = visitor.visit(tree);
        //Expression ast = (Expression) visitor.visit(tree);
        //System.out.println(ast);
        System.out.println(ast.eval());
    }
}
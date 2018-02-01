package ast;

public class Program extends AST {
    @Override
    public String gen() {
        return "#include <stdio.h>\n";
    }
}

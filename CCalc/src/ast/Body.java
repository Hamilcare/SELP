package ast;

import java.util.List;

public class Body extends AST{
    List<VarDef> varDefs;
    Expression expr;

    public Body(List<VarDef> varDefs, Expression expr) {
        this.varDefs=varDefs;
        this.expr = expr;
    }

    //@Override
    public int eval() throws Exception {
        return expr.eval();
    }

    public String gen(){
        String resul = "#include <stdio.h>\n" +
                "int main() {\n"
                + "return printf(\"%i\\n\"," +expr.gen() +");\n"
                + "}\n";
        return resul;
    }
}

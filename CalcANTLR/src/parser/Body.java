package parser;

import java.util.List;

public class Body extends AST{
    List<VarDef> varDefs;
    Expression expr;

    public Body(List<VarDef> varDefs, Expression expr) {
        this.varDefs=varDefs;
        this.expr = expr;
    }

    @Override
    public int eval() throws Exception {
        return expr.eval();
    }
}

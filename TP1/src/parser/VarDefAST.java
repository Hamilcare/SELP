package parser;

public class VarDefAST extends AST{

    IdentifierAST id;
    ExpressionAST expression;

    public VarDefAST(IdentifierAST id, ExpressionAST expression) {
        this.id = id;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "VarDef";
    }
}

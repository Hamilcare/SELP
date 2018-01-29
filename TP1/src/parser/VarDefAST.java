package parser;

public class VarDefAST extends AST{

    private IdentifierAST id;
    private ExpressionAST expression;

    public VarDefAST(IdentifierAST id, ExpressionAST expression) {
        this.id = id;
        this.expression = expression;
    }

    public IdentifierAST getId() {
        return id;
    }

    public ExpressionAST getExpression() {
        return expression;
    }

    @Override
    public boolean equals(Object varDef){
        return varDef instanceof VarDefAST && this.getId().toString().equals(((VarDefAST) varDef).getId().toString());
    }



    @Override
    public String toString() {
        return "VarDef";
    }
}

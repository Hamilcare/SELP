package parser;

import java.util.HashMap;

public class VarDefAST extends AST{

    IdentifierAST id;
    ExpressionAST expression;

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
        //System.out.println("this : "+this.id+" other : "+((VarDefAST) varDef).id);
        if(varDef instanceof VarDefAST)
            return this.getId().toString().equals(((VarDefAST) varDef).getId().toString());
        else
            return false;
    }



    @Override
    public String toString() {
        return "VarDef";
    }
}

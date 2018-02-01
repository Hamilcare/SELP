package ast;

import java.util.HashMap;

public class VarDef extends Expression{

    Identifier id;
    Expression expression;

    public VarDef(Identifier id, Expression expression) {
        this.id = id;
        this.expression = expression;
    }

    public Identifier getId() {
        return id;
    }

    public Expression getExpression() {
        return expression;
    }
/*
    @Override
    public boolean equals(Object varDef){
        if(varDef instanceof VarDefAST)
            return this.getId().toString().equals(((VarDefAST) varDef).getId().toString());
        else
            return false;
    }*/


    @Override
    public int eval() throws Exception {
        return expression.eval();
    }
}

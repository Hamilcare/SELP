package parser;

import lexer.*;

import java.util.ArrayList;
import java.util.List;

public class Body extends AST{

    List<VarDefAST> lVarDef  ;
    ExpressionAST expression ;

    public Body(List<VarDefAST> lVarDef, ExpressionAST expression) {
        this.lVarDef = lVarDef;
        this.expression = expression;
    }

    public static Body parse (Token t, List<VarDefAST>listVarDef) throws Exception {
        if(t instanceof LPar){
            Token t2 = SLexer.getToken();
            //VarDef
            if(t2 instanceof Defvar){
                ExpressionAST id = ExpressionAST.parse(SLexer.getToken());
                ExpressionAST expressionAST = ExpressionAST.parse(SLexer.getToken());
                Token last = SLexer.getToken();
                if(last instanceof RPar){
                    if(id instanceof IdentifierAST){
                        listVarDef.add(new VarDefAST((IdentifierAST)id,expressionAST));
                        return Body.parse(SLexer.getToken(),listVarDef);
                    }else{
                        throw new Exception("ERROR, Expecting VarID, found"+id+" which is "+id.getClass());
                    }
                }else{
                    throw new Exception("ERROR, Expecting right parenthesis, found "+last);
                }
            }
        }
        throw new Exception("Invalid Syntax on "+t);

    }


    @Override
    public String toString() {
        return null;
    }
}

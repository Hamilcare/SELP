package parser;

import lexer.*;
import parser.exception.RightParenthesisExpectedException;
import parser.exception.VarIDExpectedException;
import parser.exception.VariableAlreadyDefinedException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Body extends AST{

    private List<VarDefAST> lVarDef;
    private ExpressionAST expression ;
    private static Map<String,Integer> bindings;


    public Body(List<VarDefAST> lVarDef, ExpressionAST expression) {
        this.lVarDef = lVarDef;
        this.expression = expression;
    }

    public static Map<String,Integer> getBindings(){
        return bindings;
    }

    public static Body parse (Token t, List<VarDefAST>listVarDef) throws Exception {
        if(t instanceof LPar){
            Token t2 = SLexer.getToken();

            //VarDef
            if(t2 instanceof Defvar){
                ExpressionAST id = ExpressionAST.parse(SLexer.getToken(),false);
                ExpressionAST expressionAST = ExpressionAST.parse(SLexer.getToken(),false);
                Token last = SLexer.getToken();
                if(last instanceof RPar){
                    if(id instanceof IdentifierAST){
                        if(listVarDef.contains(new VarDefAST((IdentifierAST)id,expressionAST)))
                            throw new VariableAlreadyDefinedException(id.toString());
                        listVarDef.add(new VarDefAST((IdentifierAST)id,expressionAST));
                        return Body.parse(SLexer.getToken(),listVarDef);
                    }else{
                        throw new VarIDExpectedException(id.toString(),id.getClass().toString());
                    }
                }else{
                    throw new RightParenthesisExpectedException(last.toString());
                }
            }
            else{
                ExpressionAST expressionAST = ExpressionAST.parse(t2,true);
                return new Body (listVarDef,expressionAST);
            }



        }
        //ExpressionAST
        else{
            ExpressionAST expressionAST = ExpressionAST.parse(t,false);
            return new Body (listVarDef,expressionAST);
        }


    }




    @Override
    public String toString() {
        return "Liste VarDef : " + this.lVarDef.size() + "Expression "+this.expression;
    }

    public int eval() throws Exception {
        bindings = new HashMap<>(lVarDef.size());
        for(VarDefAST currentVarDef : lVarDef){
            bindings.put(currentVarDef.getId().getValue(),currentVarDef.getExpression().eval());
        }

        return this.expression.eval();
    }
}

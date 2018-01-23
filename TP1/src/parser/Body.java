package parser;

import lexer.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Body extends AST{

    List<VarDefAST> lVarDef  = new ArrayList<>();
    ExpressionAST expression ;
    public static HashMap<String,Integer> bindings;


    public Body(List<VarDefAST> lVarDef, ExpressionAST expression) {
        this.lVarDef = lVarDef;
        this.expression = expression;
    }

    public static Body parse (Token t, List<VarDefAST>listVarDef) throws Exception {
        if(t instanceof LPar){
            Token t2 = SLexer.getToken();
         //   System.out.println("current t2 "+t2);
            //VarDef
            if(t2 instanceof Defvar){
                ExpressionAST id = ExpressionAST.parse(SLexer.getToken(),false);
                ExpressionAST expressionAST = ExpressionAST.parse(SLexer.getToken(),false);
                Token last = SLexer.getToken();
                if(last instanceof RPar){
                    if(id instanceof IdentifierAST){
                        if(listVarDef.contains(new VarDefAST((IdentifierAST)id,expressionAST)))
                            throw new Exception("Variable "+id+" already defined");
                        listVarDef.add(new VarDefAST((IdentifierAST)id,expressionAST));
                        return Body.parse(SLexer.getToken(),listVarDef);
                    }else{
                        throw new Exception("ERROR, Expecting VarID, found"+id+" which is "+id.getClass());
                    }
                }else{
                    throw new Exception("ERROR, Expecting right parenthesis, found "+last);
                }
            }
            else{
                //System.out.println("Debut parse Expression ");
                ExpressionAST expressionAST = ExpressionAST.parse(t2,true);
                //System.out.println("Expression du body : " + expressionAST);
                return new Body (listVarDef,expressionAST);
            }



        }
        //ExpressionAST
        else{
            //System.out.println("Debut parse Expression ");
            ExpressionAST expressionAST = ExpressionAST.parse(t,false);
            //System.out.println("Expression du body : " + expressionAST);
            return new Body (listVarDef,expressionAST);
        }
        //throw new Exception("Invalid Syntax on "+t);

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

        //for(Map.Entry<String,Integer> entry : binding.entrySet()){
        //    System.out.println("id "+ entry.getKey() + " value: "+entry.getValue());
        //}

        return this.expression.eval();
    }
}

package ast;

import ast.Exception.UnknownOperatorException;

public enum OPUnaire {
    MINUS("-"),NOT("!");

    final private String str;

    private OPUnaire(String s){
        str =s;
    }

    public static OPUnaire parseOP(String op) throws UnknownOperatorException {
        switch (op){
            case "-": return MINUS;
            case "!": return NOT;
            default: throw  new UnknownOperatorException("OPERATEUR UNAIRE INCONNU : "+op);
        }
    }

    public String gen(){
        return str;
    }
}

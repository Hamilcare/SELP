package ast;

import ast.Exception.UnknownOperatorException;

public enum OPBinaire {
    PLUS("+"), MINUS("-"), TIMES("*"), DIVIDE("/"), EQUAL("=="), LESS("<"), MORE(">"), LESSOREQUAL("<="),
    MOREOREQUAL(">="), DIFFERENT("!="), AND("&&"), OR("||");

    final private String str;
    private OPBinaire(String s) {
        str=s;
    }

    public static OPBinaire parseOP(String op) throws UnknownOperatorException {
        switch (op){
            case "+":  return PLUS;
            case "-":  return MINUS;
            case "*":  return TIMES;
            case "/":  return DIVIDE;
            case "==": return EQUAL;
            case "<":  return LESS;
            case ">":  return MORE;
            case "<=": return LESSOREQUAL;
            case ">=": return MOREOREQUAL;
            case "!=": return DIFFERENT;
            case "&&": return AND;
            case "||": return OR;
            default: throw  new UnknownOperatorException("OPERATEUR INCONNU : "+op);
        }
    }

    public String gen(){
        return this.str;
    }
}

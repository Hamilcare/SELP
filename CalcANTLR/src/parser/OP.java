package parser;

public enum  OP {
    PLUS, MINUS, TIMES, DIVIDE, EQUAL, LESS;
    static OP parseOP(String op) throws Exception {
        switch (op){
            case "+": return PLUS;
            case "-": return MINUS;
            case "*": return TIMES;
            case "/": return DIVIDE;
            case "==": return EQUAL;
            case "<": return LESS;
            default: throw  new Exception("OPERATEUR INCONNU : "+op);
        }
    }
}

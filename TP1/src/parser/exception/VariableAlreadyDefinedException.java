package parser.exception;

public class VariableAlreadyDefinedException extends Exception {
    public VariableAlreadyDefinedException(String idVariable){
        super("Variable "+idVariable+" already defined");
    }
}

package parser.exception;

public class VariableUndefinedException extends Exception {
    public VariableUndefinedException(String idVariable){
        super("Undefined Variable : "+idVariable);
    }
}

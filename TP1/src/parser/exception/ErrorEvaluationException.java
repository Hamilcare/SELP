package parser.exception;

public class ErrorEvaluationException extends Exception {

    public  ErrorEvaluationException(String s){
        super("Erreur evaluation " + s);
    }
}

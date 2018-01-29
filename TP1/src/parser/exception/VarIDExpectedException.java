package parser.exception;

public class VarIDExpectedException extends Exception {
    public VarIDExpectedException(String id, String classFound){
        super("ERROR, Expecting VarID, found"+id+" which is "+classFound);
    }
}

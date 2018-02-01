package ast;

public class VariableId extends AST {

    Identifier id;

    public VariableId(Identifier identifier) {
        id = identifier;
    }

    @Override
    public String gen() {
        return null;
    }

    /*@Override
    public int eval() throws Exception {
        return 0;
    }*/
}

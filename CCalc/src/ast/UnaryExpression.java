package ast;

public class UnaryExpression extends Expression {
    private OPUnaire operateur;
    private Expression operande;

    public UnaryExpression(OPUnaire op, Expression expr){
        operateur = op;
        operande = expr;
    }

    @Override
    public String gen(){
        return operateur.gen()+"("+operande.gen()+")";
    }
}

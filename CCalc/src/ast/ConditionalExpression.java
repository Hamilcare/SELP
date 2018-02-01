package ast;

public class ConditionalExpression extends Expression {
    public Expression e1, e2, e3;

    public ConditionalExpression(Expression e1, Expression e2, Expression e3) {
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
    }

    @Override
    public int eval() throws Exception {
        if(e1.eval()!=0)
            return e2.eval();
        else
            return e3.eval();
    }

    @Override
    public String gen(){
        return "("+e1.gen()+"? : "+e2.gen()+" : "+e3.gen()+")";
    }

}

package ast;

public class BinaryExpression extends Expression {
    OPBinaire opBinaire;
    Expression rightOperande;
    Expression leftOperande;

    public BinaryExpression(OPBinaire opBinaire, Expression le, Expression re){
        this.opBinaire = opBinaire;
        rightOperande = re;
        leftOperande = le;
    }

    @Override
    public int eval() throws Exception{
        int left = leftOperande.eval();
        int right = rightOperande.eval();

        switch (opBinaire) {
            case MINUS:
                return left - right;
            case PLUS:
                return left + right;
            case DIVIDE:
                return left/right;
            case TIMES:
                return left * right;
            case EQUAL:
                if(left==right)
                    return 1;
                else
                    return 0;
            case DIFFERENT:
                if(left != right)
                    return 1;
                return 0;
            case LESS:
                if(left < right)
                    return 1;
                else
                    return 0;
            case MORE:
                if(left> right)
                    return 1;
                return 0;
            case MOREOREQUAL:
                if(left >= right)
                    return 1;
                return 0;
            case LESSOREQUAL:
                if(left <= right)
                    return 1;
                return 0;
            case AND:
                if(left >0 && right > 0)
                    return 1;
                return 0;
            case OR:
                if(left > 0 || right > 0)
                    return 1;
                return 0;

            default:
                throw  new Exception("Unknow operator");


        }


    }

    @Override
    public String gen(){
        return "("+leftOperande.gen()+" "+opBinaire.gen()+" "+rightOperande.gen()+")";
    }

}

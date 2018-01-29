package parser;

import com.sun.org.apache.xpath.internal.operations.Variable;

import java.util.ArrayList;
import java.util.List;

public class ASTVisitor extends CalcBaseVisitor<AST> {

    @Override
    public AST visitBody(CalcParser.BodyContext ctx) {
        // retrieve ASTs for definitions
        List<CalcParser.VarDefContext> varDefCtxs = ctx.varDef();
        List<VarDef> varDefs = new ArrayList<>();
        for (CalcParser.VarDefContext varDefCtx : varDefCtxs)
            varDefs.add((VarDef)visit(varDefCtx));

        Expression expr = (Expression)(visit(ctx.expression()));
        //System.out.println("expr : " +expr);
        // return AST for program
        return new Body(varDefs, expr);
    }

    @Override
    public AST visitProgram(CalcParser.ProgramContext ctx){
        return (Body)visit(ctx.body());
    }

    @Override
    public AST visitBinaryExpression(CalcParser.BinaryExpressionContext ctx) {
        OP op = null;
        try {
            op = OP.parseOP(ctx.OP().getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<CalcParser.ExpressionContext> expressionCtxs = ctx.expression();
        List<Expression> expressions = new ArrayList<>();
        for(CalcParser.ExpressionContext expressionCtx : expressionCtxs) {
            expressions.add((Expression) visit(expressionCtx));
        }

        return new BinaryExpression(op,expressions.get(0), expressions.get(1));

    }

    @Override
    public AST visitVarDef(CalcParser.VarDefContext ctx){
        return new VarDef((Identifier)visit(ctx.variableId()), (Expression)visit(ctx.expression()));
    }

    //@Override
    public AST visitVariableId(CalcParser.VariableContext ctx){
        return new VariableId(new Identifier(ctx.getText()));
    }


    @Override
    public AST visitConditionalExpression(CalcParser.ConditionalExpressionContext ctx){
        List<CalcParser.ExpressionContext> expressionCtxs = ctx.expression();
        List<Expression> expressions = new ArrayList<>();
        for(CalcParser.ExpressionContext expressionCtx : expressionCtxs){
            expressions.add((Expression) visit(expressionCtx));
        }
        return new ConditionalExpression(expressions.get(0), expressions.get(1), expressions.get(2));
    }

    @Override
    public AST visitUnaryExpression(CalcParser.UnaryExpressionContext ctx){
        Expression expression1 = (Expression)visit(ctx.expression());
        CalcParser.TailContext tailCtx = ctx.tail();
        if(tailCtx.expression()==null){
            return new UnaryExpression(expression1);
        }
        else{
            return new BinaryExpression(OP.MINUS,expression1,(Expression)visit(tailCtx.expression()));
        }
    }

    @Override
    public AST visitLiteral(CalcParser.LiteralContext ctx){
        return new Literal(Integer.parseInt(ctx.getText()));
    }


}

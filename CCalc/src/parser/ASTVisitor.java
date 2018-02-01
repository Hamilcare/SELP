package parser;


import ast.*;
import ast.Exception.UnknownOperatorException;
import calc.Calc;

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
        // return AST for program
        return new Body(varDefs, expr);
    }

    @Override
    public AST visitProgram(CalcParser.ProgramContext ctx){
        return (Body)visit(ctx.body());
    }

    public AST visitUnaryExpression(CalcParser.UnaryExpressionContext ctx){
        OPUnaire opUnaire = null;
        try {
            opUnaire = OPUnaire.parseOP(ctx.getChild(0).getText());
        } catch (UnknownOperatorException e) {
            e.printStackTrace();
        }

        Expression expr = (Expression)visit(ctx.expression());
        return new UnaryExpression(opUnaire, expr);
    }

    @Override
    public AST visitBinaryExpression(CalcParser.BinaryExpressionContext ctx) {
        OPBinaire opBinaire = null;
        try {
            opBinaire = OPBinaire.parseOP(ctx.getChild(1).getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<CalcParser.ExpressionContext> expressionCtxs = ctx.expression();
        List<Expression> expressions = new ArrayList<>();
        for(CalcParser.ExpressionContext expressionCtx : expressionCtxs) {
            expressions.add((Expression) visit(expressionCtx));
        }

        return new BinaryExpression(opBinaire,expressions.get(0), expressions.get(1));

    }

    @Override
    public AST visitParExpression(CalcParser.ParExpressionContext ctx){
        return (Expression)visit(ctx.expression());
    }

    @Override
    public AST visitVarDef(CalcParser.VarDefContext ctx){
        return new VarDef((Identifier)visit(ctx.variableId()), (Expression)visit(ctx.expression()));
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
   public AST visitBoolean (CalcParser.BooleanContext ctx){
        return new BooleanValue(ctx.getText());
   }

    @Override
    public AST visitLiteral(CalcParser.LiteralContext ctx){
        return new Literal(Integer.parseInt(ctx.getText()));
    }


}

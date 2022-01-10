package test2.termcalc;


import test2.expression.AbsoluteValueExpression;
import test2.expression.DifferenceExpression;
import test2.expression.Expression;
import test2.expression.NumberExpression;

/**
 * Class to implement ExpressionMaker and create a new Expression
 *
 * @author zhilinh
 */
public class ExpressionMakerImp implements ExpressionMaker {

    /**
     * Method that returns a new Expression of the sum of addend1 and addend2.
     */
    @Override
    public Expression sumExpression(Expression addend1, Expression addend2) {
//		throw new Exception("Need to be implemented！");
        double res = addend1.eval() + addend2.eval();
        Expression expression = new NumberExpression(res);
        return expression;
    }

    /**
     * Method that returns a new Expression of the difference of op1 and op2.
     */
    @Override
    public Expression differenceExpression(Expression op1, Expression op2) {
//		throw new Exception("Need to be implemented！");
        double res = op1.eval() - op2.eval();
        Expression expression = new NumberExpression(res);
        return expression;

    }

    /**
     * Method that returns a new Expression of the product of factor1 and factor2.
     */
    @Override
    public Expression productExpression(Expression factor1, Expression factor2) {
//		throw new Exception("Need to be implemented！");
        double res = factor1.eval() * factor2.eval();
        Expression expression = new NumberExpression(res);
        return expression;
    }

    /**
     * Method that returns a new Expression of the division of dividend and divisor.
     */
    @Override
    public Expression divisionExpression(Expression dividend, Expression divisor) {
//		throw new Exception("Need to be implemented！");
        double res = dividend.eval() / divisor.eval();
        Expression expression = new NumberExpression(res);
        return expression;
    }

    /**
     * Method that returns a new Expression of the exponentiation of base and exponent.
     */
    @Override
    public Expression exponentiationExpression(Expression base, Expression exponent) {
//		throw new Exception("Need to be implemented！");
        double res1 = base.eval();
        double res2 = exponent.eval();
        double res=Math.pow(res1,res2);
        Expression expression1 = new NumberExpression(res);
        return expression1;
    }

    /**
     * Method that returns a new Expression of the the negated operand.
     */
    @Override
    public Expression negationExpression(Expression operand) {
//		throw new Exception("Need to be implemented！");
        double res = operand.eval();
        Expression expression1 = new NumberExpression(-res);
        return expression1;
    }

    /**
     * Method that returns a new Expression of the absolute value Expression of value.
     */
    @Override
    public Expression absoluteValueExpression(Expression value) {
//		throw new Exception("Need to be implemented！");
        Expression expression = new AbsoluteValueExpression(value);
        double res = expression.eval();
        Expression expression1 = new NumberExpression(res);
        return expression1;
    }

    /**
     * Method that returns a new Expression of the value.
     */
    @Override
    public Expression numberExpression(double value) {
//		throw new Exception("Need to be implemented！");
        Expression expression = new NumberExpression(value);
        return expression;
    }

}

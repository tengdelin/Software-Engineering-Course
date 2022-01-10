package test2.expression;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;


class DerivativeExpressionTest {

    @Test
    void eval() {
        //测试的是x的平方+x的导数，x=1,x的导数为3.0;
        Variable x = new Variable("x");
        x.store(1);
        ProductExpression productExpression = new ProductExpression(x, x);
        SumExpression sum = new SumExpression(productExpression, x);
        DerivativeExpression derivativeExpression = new DerivativeExpression(sum, x);
        Assertions.assertEquals(3.000000248221113,derivativeExpression.eval());
    }
}
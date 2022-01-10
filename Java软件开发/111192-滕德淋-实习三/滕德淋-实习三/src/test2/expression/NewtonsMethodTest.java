package test2.expression;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NewtonsMethodTest {
    @Test
    void zero() {
        Variable x = new Variable("x");
        ProductExpression pro = new ProductExpression(x, x);
        NumberExpression num = new NumberExpression(2);
        DifferenceExpression dif = new DifferenceExpression(pro, num);
        NewtonsMethod newtonsMethod = new NewtonsMethod();
        Assertions.assertEquals(1.4142156864773054,
                newtonsMethod.zero(dif, x, 2, 0.01));
    }
}
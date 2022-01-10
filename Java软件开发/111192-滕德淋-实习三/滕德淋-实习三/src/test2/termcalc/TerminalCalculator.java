package test2.termcalc;
import test2.expression.Expression;

import java.util.Objects;



/**
 * TerminalCalculator - a command line calculator.
 */
public class TerminalCalculator {
    //CHECKSTYLE:OFF
    private final ExpressionParser parser;

    TerminalCalculator(ExpressionMaker maker) {
        Objects.requireNonNull(maker);
        parser = new ExpressionParser(maker);
    }

    public Expression run(String expression) {
        return parser.eval(expression);
    }
}

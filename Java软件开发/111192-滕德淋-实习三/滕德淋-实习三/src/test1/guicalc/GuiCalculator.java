package test1.guicalc;



import test1.operator.BinaryOperator;
import test1.operator.UnaryOperator;

import java.util.*;

import javax.swing.SwingUtilities;



/**
 * GuiCalculator - creates and runs a new CalculatorController to visualize a desktop calculator.
 */
public class GuiCalculator {
    //CHECKSTYLE:OFF
    private Set<UnaryOperator> unaryOperators;
    private Set<BinaryOperator> binaryOperators;

    /**
     * Initialize valid operators in GUI Calculator.
     *
     * @param unaryOperators the unary operators that the calculator supports
     * @param binaryOperators the binary operators that the calculator supports
     */
    public GuiCalculator(Set<UnaryOperator> unaryOperators, Set<BinaryOperator> binaryOperators) {
        this.unaryOperators = new LinkedHashSet<>(Objects.requireNonNull(unaryOperators));
        this.binaryOperators = new LinkedHashSet<>(Objects.requireNonNull(binaryOperators));
        SwingUtilities.invokeLater(() -> createAndShowSetupScreen());
    }

    // launch the calculator
    private void createAndShowSetupScreen() {
        CalculatorController controller = new CalculatorController(unaryOperators, binaryOperators);
        controller.launch();
    }

}

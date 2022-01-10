package test1.guicalc;


import test1.operator.BinaryOperator;
import test1.operator.BinaryOperatorImp;

import test1.operator.UnaryOperator;
import test1.operator.UnaryOperatorImp;

import java.util.HashSet;
import java.util.Set;



/**
 * Main program that runs the GUI Calculator
 */
public class Main {

    /**
     * Add BinaryOperators and UnaryOperators implements to the calculator.
     *
     * @param args as input
     */
    public static void main(String[] args) {
        // Generating OperatorSet
        //单目运算符集合
        UnaryOperatorImp u1=UnaryOperatorImp.ABS;
        UnaryOperatorImp u2=UnaryOperatorImp.NEGATION;
        UnaryOperatorImp u3=UnaryOperatorImp.SIN;
        UnaryOperatorImp u4=UnaryOperatorImp.COS;
        UnaryOperatorImp u5=UnaryOperatorImp.TAN;
        UnaryOperatorImp u6=UnaryOperatorImp.LOG;

        Set<UnaryOperator> unary = new HashSet<>();
        unary.add(u1);
        unary.add(u2);
        unary.add(u3);
        unary.add(u4);
        unary.add(u5);
        unary.add(u6);


        //双目运算符集合
        BinaryOperatorImp b1=BinaryOperatorImp.ADDITION;
        BinaryOperatorImp b2=BinaryOperatorImp.SUBTRACTION;
        BinaryOperatorImp b3=BinaryOperatorImp.MULTIPLICATION;
        BinaryOperatorImp b4=BinaryOperatorImp.DIVISION;
        BinaryOperatorImp b5=BinaryOperatorImp.EXPONENTIATION;
        Set<BinaryOperator> binary = new HashSet<>();
        binary.add(b1);
        binary.add(b2);
        binary.add(b3);
        binary.add(b4);
        binary.add(b5);
        //初始化计算对象
        GuiCalculator cal=new GuiCalculator(unary,binary);

    }
}

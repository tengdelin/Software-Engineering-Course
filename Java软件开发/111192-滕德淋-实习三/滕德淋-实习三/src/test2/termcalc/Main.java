package test2.termcalc;

import test2.expression.Expression;
import test2.expression.NumberExpression;

import java.util.Scanner;


/**
 * Main entry point for the command line calculator
 */
public class Main {
    /**
     * @param args program arguments
     */
    public static void main(String[] args) {
        ExpressionMaker maker = new ExpressionMakerImp();
        TerminalCalculator ter=new TerminalCalculator(maker);

        Scanner sc = new Scanner(System.in);
        String cmd = "";
        while(true){
            System.out.println("enter an Expression: ");
            cmd = sc.nextLine();
            if (cmd.equals("q")){
                break;
            }
            System.out.println("Result: ");
            System.out.println(ter.run(cmd));
        }
        System.out.println("退出成功！");
    }
}

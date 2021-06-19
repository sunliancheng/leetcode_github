package ClassicAlgorithmsTest;

import ClassicAlgorithms.stack.expression.expression;
import org.junit.Test;

public class expTest {

    @Test
    public void test() {
        String exp = "9 +(3-1)*3+10/2";
        exp = "3+2*2";
        exp = exp.replaceAll(" ", "");
        System.out.println(exp);
        System.out.println(expression.exp2InfixExp(exp));
        System.out.println(expression.exp2RPN(exp));
        System.out.println(expression.evalRPN(expression.exp2RPN(exp)));
    }
}

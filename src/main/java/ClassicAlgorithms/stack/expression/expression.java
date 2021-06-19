package ClassicAlgorithms.stack.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class expression {

    /**
     * 把普通表达式转换成后缀表达式
     * @param exp
     * @return
     */
    public static List<String> exp2RPN(String exp) {

        // 结果集
        List<String> result = new ArrayList<>();

        // 把表达式转化成中缀表达式
        List<String> tokens = exp2InfixExp(exp);

        // 初始化两个栈，运算符栈 s1 和 存储中间结果的栈 s2
        Stack<String> stack = new Stack<>();

        // 从左往右扫描中缀表达式
        for (String token : tokens) {

            if (token.matches("\\d+")) {
                // 遇到操作数，将其压入 s2
                result.add(token);
            } else if ("-+*/".contains(token)) {
                while (true) {
                    // 如果stack为空 或者 栈顶是 左括号，那么直接将运算符压入栈
                    if (stack.isEmpty() || stack.peek().contains("(")) {
                        stack.push(token);
                        break;
                    } else {
                        // 遇到操作符，比较其与 s1 栈顶运算符的优先级
                        String opTop = stack.peek();
                        if (opIsLarger(token, opTop)) {
                            // 如果比栈顶运算级别高，将运算符压入栈
                            stack.push(token);
                            break;
                        } else {
                            // 反之，把栈顶元素弹出，压入后缀表达式中
                            // 然后继续比较 新的栈顶元素和当前运算符优先级
                            result.add(stack.pop());
                        }
                    }
                }
            } else if ("(".contains(token)) {
                // 左括号 直接压入栈
                stack.push(token);

            } else if (")".contains(token)) {
                // 右括号 依次弹出栈顶运算符直到遇到左括号
                while (!stack.peek().equals("(")) {
                    result.add(stack.pop());
                }
                stack.pop();
            }
        }
        // 把栈中剩余的符号全都放入list中，最终结果就是逆波兰表达式
        while (!stack.isEmpty()) result.add(stack.pop());
        return result;
    }

    /**
     * 把普通表达式转换成中缀表达式
     * @param s
     * @return
     */
    public static List<String> exp2InfixExp(String s) {
        List<String> ls = new ArrayList<>();
        int i = 0; String str; char c;
        do {
            if ((c = s.charAt(i)) < 48 || c > 57) {
                ls.add("" + c);
                ++i;
            } else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && c <= 57) {
                    str += c;
                    ++i;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

    /**
     * 使用逆波兰表达式计算表达式的值
     * @param tokens
     * @return
     */
    public static int evalRPN(List<String> tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("-+*/".contains(token)) {
                stack.push(cal(stack.pop(), stack.pop(), token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    /**
     * 给定两个数字 和一个 操作符 进行计算
     * @param b
     * @param a
     * @param op
     * @return
     */
    public static int cal(int b, int a, String op) {
        if (op.equals("-")) return a - b;
        else if (op.equals("+")) return a + b;
        else if (op.equals("*")) return a * b;
        else return a / b;
    }

    /**
     * 比较两个操作符运算级别高低
     * @param op1
     * @param op2
     * @return
     */
    public static boolean opIsLarger(String op1, String op2) {
        int[] o = new int[2];
        String[] ops = new String[2];
        ops[0] = op1; ops[1] = op2;

        for (int i = 0; i < 2; ++i) {
            String op = ops[i];
            if ("/*".contains(op)) o[i] = 2;
            else o[i] = 1;
        }
        return o[0] > o[1];
    }

}

package LC0_200.LC150_200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC150_Evaluate_Reverse_Polish_Notation {

    @Test
    public void test() {
        System.out.println(calculate("3+2*2"));
    }


    public int calculate(String s) {
        // 1. 去除字符串中的空格
        s = s.replaceAll(" ", "");

        // 2. 把表达式转换成中缀表达式
        List<String> infixExp = exp2InfixExp(s);

        // 3. 把表达式转成后缀表达式
        List<String> RPNExp = infixExp2RPN(infixExp);

        // 4. 计算后缀表达式的值
        return evalRPN(RPNExp);

    }

    // 把表达式转成中缀表达式
    public List<String> exp2InfixExp(String s) {
        List<String> ls = new ArrayList<>();
        int i = 0; String str; char c;
        do {
            if ((c = s.charAt(i)) < 48 || c > 57) {
                ls.add("" + c);
                ++i;
            } else {
                str = "";
                while (i < s.length() && ((c = s.charAt(i)) >= 48 && c <= 57)) {
                    str += c;
                    ++i;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

    // 把中缀表达式转成后缀表达式（逆波兰式子）
    public List<String> infixExp2RPN(List<String> tokens) {
        List<String> result = new ArrayList<>();
        // 初始化一个栈，存储当前临时
        Stack<String> stack = new Stack<>();

        // 从左往右扫描中缀表达式
        for (String token : tokens) {

            if (token.matches("\\d+")) {
                // 如果是操作数，直接放入后缀表达式结果集合 result 中
                result.add(token);
            } else if (token.equals("(")) {
                // 如果是 左括号，直接压入操作符栈中
                stack.push(token);
            } else if (token.equals(")")) {
                // 如果是 右括号，依次弹出栈顶运算符直到遇到左括号
                while (!stack.peek().equals("(")) result.add(stack.pop());
                // 把左括号 弹出
                stack.pop();
            } else if ("-+*/".contains(token)) {
                // 如果当前是个 操作符
                while(true) {
                    // 如果stack为空， 或者栈顶是左括号，那么直接将运算符压入栈
                    if (stack.isEmpty() || stack.peek().equals("(")) {
                        stack.push(token);
                        // 跳出循环
                        break;
                    } else {
                        // 需要比较当前操作符与栈顶操作符的优先级
                        String opTop = stack.peek();
                        if (opIsLargerThan(token, opTop)) {
                            // 如果当前操作符优先级比栈顶高，直接压入栈
                            stack.push(token);
                            break;
                        } else {
                            // 如果当前操作符优先级比栈顶底，则弹出栈顶操作符，放入后缀表达式结果集中
                            // 然后继续循环比较 新的栈顶元素和当前运算符的优先级
                            result.add(stack.pop());
                        }
                    }
                }
            }
        }
        // 把剩下的栈元素放入 后缀表达式集合中
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    // 计算后缀表达式的值
    public int evalRPN(List<String> tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("-+*/".contains(token)) stack.push(cal(stack.pop(), stack.pop(), token));
            else stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }

    // 两个数 和 一个操作符 来计算他们运算后的结果
    public int cal(int b, int a, String op) {
        if (op.equals("-")) return a - b;
        else if (op.equals("+")) return a + b;
        else if (op.equals("*")) return a * b;
        else return a / b;
    }

    // 比较操作符 op1 是否优先级高于 操作符 op2
    public boolean opIsLargerThan(String op1, String op2) {
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

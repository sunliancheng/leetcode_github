package LC0_200.LC150_200;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class LC155_Min_Stack {

    /** initialize your data structure here. */
//    public MinStack() {
//
//    }

    Deque<Integer> s = new LinkedList<>(), min = new LinkedList<>();
    public void push(int x) {
        s.push(x);
        if (min.isEmpty() || min.peek() >= x)
            min.push(x);
    }

    public void pop() {
        if (!min.isEmpty() && min.peek().equals(s.peek()))
            min.pop();
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min.peek();
    }


    @Test
    public void test() {


        Integer i = 128;
        Integer j = 128;

        System.out.println(i == j);
    }

}

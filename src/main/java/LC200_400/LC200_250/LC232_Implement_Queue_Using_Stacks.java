package LC200_400.LC200_250;

import java.util.Deque;
import java.util.LinkedList;

public class LC232_Implement_Queue_Using_Stacks {

    Deque<Integer> in = null;
    Deque<Integer> out = null;
    /** Initialize your data structure here. */
//    public MyQueue() {
//        in = new LinkedList<>();
//        out = new LinkedList<>();
//    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        in2out();
        int x = out.pop();
        return x;
    }

    /** Get the front element. */
    public int peek() {
        in2out();
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    void in2out() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                int x = in.pop();
                out.push(x);
            }
        }
    }

}

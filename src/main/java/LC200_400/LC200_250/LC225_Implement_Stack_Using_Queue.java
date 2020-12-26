package LC200_400.LC200_250;

import org.junit.Test;

import javax.swing.text.html.HTMLDocument;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class LC225_Implement_Stack_Using_Queue {

    @Test
    public void test() {
        MyStack myStack = new MyStack();
        myStack.push(1); myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}

class MyStack {

    Queue<Integer> queue, queue2; // queue is the stack
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        queue.clear();
        int result = 0;
        Iterator<Integer> iterator = queue2.iterator();
        int count = queue2.size();
        while (iterator.hasNext()) {
            result = (iterator.next());
            if (--count <= 0)
                break;
            queue.offer(result);
        }
        Queue<Integer> tem = queue;
        queue = queue2; queue2 = tem;
        return result;
    }

    /** Get the top element. */
    public int top() {
        int result = 0;
        Iterator<Integer> iterator = queue2.iterator();
        int count = queue2.size();
        while (iterator.hasNext()) {
            result = iterator.next();
        }
        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue2.isEmpty();
    }
}
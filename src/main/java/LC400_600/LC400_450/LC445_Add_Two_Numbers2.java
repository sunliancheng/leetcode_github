package LC400_600.LC400_450;

import LeetCodeUtils.ListNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class LC445_Add_Two_Numbers2 {

    @Test
    public void test() {
        ListNode a = new ListNode(7);
        a.next = new ListNode(2);
        a.next.next = new ListNode(4);
        a.next.next.next = new ListNode(3);

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);

        addTwoNumbers(a, b);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque1 = handle(l1);
        Deque<Integer> deque2 = handle(l2);
        if (deque1.size() < deque2.size()) {
            Deque<Integer> tem = deque1;
            deque1 = deque2;
            deque2 = tem;
        }

        int carry = 0; ListNode current = null;
        int len = deque1.size();
        for (int i = 0; i < len; ++i) {
            int val = 0;
            if (deque2.size() > 0) {
                val = deque1.removeLast() + deque2.removeLast() + carry;
            } else
                val = deque1.removeLast() + carry;
            if (val >= 10) {
                val -= 10;
                carry = 1;
            } else
                carry = 0;
            current = addFirst(val, current);
        }

        if (carry == 1)
            current = addFirst(1, current);

        return current;
    }

    public Deque<Integer> handle(ListNode l) {
        Deque<Integer> dq = new LinkedList<>();
        for (ListNode p = l; p != null; p = p.next)
            dq.addLast(p.val);
        return dq;
    }

    public ListNode addFirst(int val, ListNode node) {
        ListNode n = new ListNode(val);
        n.next = node;
        return n;
    }

}

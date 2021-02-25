package LC0_200.LC100_150;

import LeetCodeUtils.ListNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class LC143_Reorder_List {

    @Test
    public void test() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        //ListNode node3 = new ListNode(3);
        //ListNode node4 = new ListNode(4);
        //ListNode node5 = new ListNode(5);
        //ListNode node6 = new ListNode(6);
        //ListNode node7 = new ListNode(7);
        node1.next = node2; //.next = node3; node3.next = node4; node4.next = node5;
        //node5.next = node6; node6.next = node7;
        reorderList(node1);
    }

    Deque<ListNode> deque = new LinkedList<>();

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        boolean flag = false;
        ListNode fast = head, slow = head, prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
            flag = flag == true ? false : true;
        }
        if (flag) {
            prev = slow;
            slow = slow.next;
        }
        add(slow);
        prev.next = null;
        slow = head;
        while (slow != null) {
            ListNode next = slow.next;
            if (deque.size() == 0) return;
            ListNode tem = deque.removeLast();
            tem.next = next;
            slow.next = tem;
            slow = next;
        }
        if (deque.size() != 0) {
            ListNode t = deque.removeLast(), p = head;
            t.next = null;
            while (head.next != null) {
                head = head.next;
            }
            head.next = t;
        }
        System.out.println("d");

    }

    public void add(ListNode root) {
        for (ListNode node = root; node != null; node = node.next) {
            deque.addLast(node);
        }
    }



}

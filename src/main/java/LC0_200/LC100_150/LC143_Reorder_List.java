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
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2; node2.next = node3; node3.next = node4;
        reorderList(node1);
    }

    Deque<ListNode> deque = new LinkedList<>();

    public void reorderList(ListNode head) {

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = head.next;
        }
        add(slow.next);
        slow.next = null;
        slow = head;
        while (slow != null) {
            ListNode next = slow.next;
            if (deque.size() == 0) return;
            ListNode tem = deque.removeLast();
            tem.next = next;
            slow.next = tem;
        }

    }

    public void add(ListNode root) {
        for (ListNode node = root; node != null; node = node.next) {
            deque.addLast(node);
        }
    }



}

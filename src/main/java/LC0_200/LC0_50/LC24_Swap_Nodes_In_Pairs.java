package LC0_200.LC0_50;

import LeetCodeUtils.ListNode;

public class LC24_Swap_Nodes_In_Pairs {
    public ListNode swapPairs(ListNode head) {
        ListNode p = head, s = null;
        if (p != null && p.next != null) {
            s = p.next;
            p.next = s.next;
            s.next = p;
            head = s;
            while (p.next != null && p.next.next != null) {
                s = p.next.next;
                p.next.next = s.next;
                s.next = p.next;
                p.next = s;
                p = s.next;
            }
        }
        return head;
    }
}

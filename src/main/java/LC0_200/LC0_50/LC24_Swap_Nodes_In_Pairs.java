package LC0_200.LC0_50;

import LeetCodeUtils.ListNode;

public class LC24_Swap_Nodes_In_Pairs {
    public ListNode swapPairs(ListNode head) {

        ListNode parent = new ListNode(), first = null, second = null, hhead = null;
        parent.next = head; hhead = parent;

        while (hhead.next != null && hhead.next.next != null) {
            // get first and second node
            first = hhead.next;
            second = hhead.next.next;
            // exchange
            hhead.next = second;
            first.next = second.next;
            second.next = first;
            // next step
            hhead = first;
        }

        return parent.next;
    }
}

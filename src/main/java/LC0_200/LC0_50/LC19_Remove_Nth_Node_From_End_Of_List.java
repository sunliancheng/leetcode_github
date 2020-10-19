package LC0_200.LC0_50;

import LeetCodeUtils.ListNode;

public class LC19_Remove_Nth_Node_From_End_Of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode quick = root, slow = root;
        int step = 0;

        while (quick.next != null) {
            quick = quick.next;
            step++;
            if (step > n) {
                slow = slow.next;
            }
        }

        slow.next = slow.next.next;

        return root.next;
    }
}

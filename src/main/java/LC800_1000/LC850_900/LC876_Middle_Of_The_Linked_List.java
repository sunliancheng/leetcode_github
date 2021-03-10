package LC800_1000.LC850_900;

import LeetCodeUtils.ListNode;

public class LC876_Middle_Of_The_Linked_List {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

}

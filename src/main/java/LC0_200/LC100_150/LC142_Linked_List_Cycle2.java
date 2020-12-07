package LC0_200.LC100_150;

import LeetCodeUtils.ListNode;

public class LC142_Linked_List_Cycle2 {

    public void test() {

    }



    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null)
                return null;
            slow = slow.next;
            if (fast.next == null)
                return null;
            fast = fast.next.next;

            if (fast == slow)
                break;
            // 2 (x + ND + dx ) = (x + MD + dx)
            // x + 2ND - MD + dx = 0
            // x + dx = (M - 2N) D
            // x = (M - 2N) D - dx
            // x = QD - dx
        }

        for (fast = head; fast != slow; fast = fast.next)
            slow = slow.next;

        return fast;
    }

}

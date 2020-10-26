package LC0_200.LC50_100;

import LeetCodeUtils.ListNode;

public class LC83_Remove_Duplicates_From_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while(p != null && p.next != null) {
            q = p;
            while(q.next != null && q.val == q.next.val)
                q = q.next;
            p.next = q.next;
            p = p.next;
        }
        return head;
    }
}

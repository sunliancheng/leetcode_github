package LC0_200.LC50_100;

import LeetCodeUtils.ListNode;

public class LC86_Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode p = head, first = new ListNode(), end = new ListNode(), f = first, e = end;

        while (p != null) {
            ListNode tem = p.next;
            if (p.val < x) {
                f.next = p;
                p.next = null;
                f = p;
                p = tem;
            } else {
                e.next = p;
                p.next = null;
                e = p;
                p = tem;
            }
        }

        f.next = end.next;
        return first.next;
    }

}

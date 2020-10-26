package LC0_200.LC50_100;

import LeetCodeUtils.ListNode;

public class LC92_Reverse_Linked_List2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode headd = new ListNode(0, head);
        ListNode cur = headd, start = null, end = null, cur_start = new ListNode(0, null), cur_end = null;
        int count = 0;
        while(count <= n) {
            ListNode next = cur.next;
            if(count == m - 1)
                start = cur;
            else if(count == n) {
                end = cur.next;
            }
            //in the range
            if(count >= m && count <= n) {
                cur.next = cur_start.next;
                cur_start.next = cur;
                if(count == m)
                    cur_end = cur;
            }
            count++;
            cur = next;
        }
        start.next = cur_start.next;
        cur_end.next = end;
        return headd.next;
    }
}

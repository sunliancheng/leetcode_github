package LC0_200.LC0_50;

import LeetCodeUtils.ListNode;

public class LC25_Reverse_Nodes_In_K_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        for(ListNode p = head; p != null; p = p.next) {
            ++len;
        }
        int times = 0;
        int m = 0, n = 0;
        while(k * times + k <= len) {
            m = k * times + 1;
            n = k * times + k;
            head = reverseBetween(head, m, n);
            times++;
        }
        return head;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode headd = new ListNode(0, head);
        ListNode cur = headd, start = null, end = null, cur_start = new ListNode(0, null), cur_end = null;
        int count = 0;
        ListNode next;
        while(count <= n) {
            next = cur.next;
            if(count == m - 1)
                start = cur;
            else if(count == n) {
                end = cur.next;
            }

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

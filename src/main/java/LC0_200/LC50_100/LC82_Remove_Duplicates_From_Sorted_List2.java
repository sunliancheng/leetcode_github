package LC0_200.LC50_100;

import LeetCodeUtils.ListNode;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

public class LC82_Remove_Duplicates_From_Sorted_List2 {

    @Test
    public void test() {
        System.out.println(deleteDuplicates(ListNode.createListNode("1,2,3,3,4,4,5")));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(), p = pre, q = pre.next;
        pre.next = head; q = pre.next;

        int cur = Integer.MAX_VALUE;
        while ( q != null) {
            if (q.val == cur) {
                q = q.next;
                pre.next = q;
            } else {
                cur = q.val;
                if (q.next != null && q.next.val != cur) {
                    pre.next = q;
                    pre = pre.next;
                    q = q.next;
                } else if (q.next != null && q.next.val == cur){
                    q = q.next;
                    pre.next = q;
                } else if (q.next == null) {
                    pre.next = q;
                    pre = pre.next;
                }
            }
        }
        ListNode.print(p.next);
        return p.next;
    }

}

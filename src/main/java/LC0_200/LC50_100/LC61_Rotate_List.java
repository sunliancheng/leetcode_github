package LC0_200.LC50_100;

import LeetCodeUtils.ListNode;
import org.junit.Test;

public class LC61_Rotate_List {

    @Test
    public void test() {
        ListNode.print(rotateRight(ListNode.createListNode("1"), 0));
        //System.out.println(count(ListNode.createListNode("1,2,3,4,5")));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode res = new ListNode();
        int len = count(head);
        k = len - k % len;
        ListNode pre = head, p = head;
        for (int i = 0; i < k; ++i) {
            if (i == k - 1)
                pre = p;
            p = p.next;
        }
        res.next = p;
        pre.next = null;
        if (p != null) {
            while (p.next != null)
                p = p.next;
            p.next = head;
        } else {
            res.next = head;
        }
        return res.next;
    }

    public int count(ListNode head) {
        ListNode p = head;
        int res = 0;
        while (p != null) {
            res++;
            p = p.next;
        }

        return res;
    }

}

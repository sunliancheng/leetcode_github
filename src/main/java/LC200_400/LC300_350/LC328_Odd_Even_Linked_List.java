package LC200_400.LC300_350;

import LeetCodeUtils.ListNode;
import org.junit.Test;

public class LC328_Odd_Even_Linked_List {

    @Test
    public void test() {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        //ListNode d = new ListNode(4);
        a.next = b; b.next = c; //c.next = d;
        oddEvenList(a);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}

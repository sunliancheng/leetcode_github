package LC200_400.LC200_250;

import LeetCodeUtils.ListNode;

public class LC203_Remove_Linked_List_Elements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode first = new ListNode(0);
        first.next = head;
        remove(first, val);
        return first.next;
    }

    public void remove(ListNode node, int val) {
        if (node == null) return;
        if (node.next != null && node.next.val == val) {
            ListNode next = node.next.next;
            node.next = next;
            remove(node, val);
        } else
            remove(node.next, val);

    }

}

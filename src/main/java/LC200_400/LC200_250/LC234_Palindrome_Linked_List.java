package LC200_400.LC200_250;

import LeetCodeUtils.ListNode;

public class LC234_Palindrome_Linked_List {


    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reserveList(slow.next, null);
        slow = slow.next;
        while (slow != null) {
            if (head.val != slow.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    ListNode reserveList(ListNode head, ListNode prev) {
        if (head == null)
            return prev;
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        return reserveList(next, head);
    }

}

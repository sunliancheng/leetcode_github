package LC1600_1800.LC1650_1700;

import LeetCodeUtils.ListNode;

public class LC1669_Merge_In_Between_Linked_Lists {


    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode first = list1, second = list1;
        for (int i = 0; i < b; ++i) {
            if (i < a - 1) first = first.next;
            second = second.next;
        }

        first.next = list2;

        for (first = list2; first.next != null; first = first.next) { }

        first.next = second.next;
        return list1;
    }

}

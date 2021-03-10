package LC1200_1400.LC1250_1300;

import LeetCodeUtils.ListNode;

public class LC1290_Convert_Binary_Number_In_A_Linked_List_To_Integer {

    public int getDecimalValue(ListNode head) {
        ListNode p = head;
        int ans = 0;
        while (p != null) {
            ans = ans * 2 + p.val;
            p = p.next;
        }
        return ans;
    }

}

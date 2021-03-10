package LC1600_1800.LC1700_1750;

import LeetCodeUtils.ListNode;

public class LC1721_Swapping_Nodes_In_A_Linked_List {

    public ListNode swapNodes(ListNode head, int k) {

        ListNode p = head, one = head, two = head;
        for (int i = 0; i < k; ++i)
            two = two.next;
        int i = 1; boolean flag = false;
        while (p != null) {
            if (i == k)
                one = p;
            if (two == null) {
                two = p;
                flag = true;
            } else if (flag == false)
                two = two.next;
            p = p.next;
            ++i;
        }
        int val = two.val;
        two.val = one.val;
        one.val = val;
        return head;
    }

}

package LC600_800.LC700_750;

import LeetCodeUtils.ListNode;

public class LC725_Split_Linked_List_In_Parts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = len(root);
        ListNode[] result = new ListNode[k];
        int n = len / k, m = len % k;
        ListNode p = root;
        while (p != null) {


            p = p.next;
        }
        return null;
    }

    public int len(ListNode head) {
        ListNode p = head;
        int i = 0;
        while (p != null) {
            p = p.next;
            i++;
        }
        return i;
    }

}

package LC600_800.LC700_750;

import LeetCodeUtils.ListNode;
import org.junit.Test;

public class LC725_Split_Linked_List_In_Parts {

    @Test
    public void test() {
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3)));
        splitListToParts(root, 5);
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, rem = N % k;
        ListNode[] ans = new ListNode[k];
        cur = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = cur;
            for (int j = 0; j < width + (i < rem ? 1 : 0) - 1; ++j)
                if (cur != null) cur = cur.next;

            if (cur != null) {
                ListNode prev = cur;
                cur = cur.next;
                prev.next = null;
            }
            ans[i] = head;
        }
        return ans;
    }

}

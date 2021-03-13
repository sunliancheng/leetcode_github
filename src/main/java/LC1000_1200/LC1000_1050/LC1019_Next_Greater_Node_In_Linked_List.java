package LC1000_1200.LC1000_1050;

import LeetCodeUtils.ListNode;

public class LC1019_Next_Greater_Node_In_Linked_List {

    public int[] nextLargerNodes(ListNode head) {
        int len = getLen(head);
        int[] ans = new int[len], result = new int[len];
        handle(head, ans);
        for (int i = 0; i < ans.length; ++i) {
            for (int j = i + 1; j < ans.length; ++j) {
                if (ans[j] > ans[i]) {
                    result[i] = ans[j];
                    break;
                }
            }
        }
        return result;
    }

    public int getLen(ListNode head) {
        int ans = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            ++ans;
        }
        return ans;
    }

    public void handle(ListNode head, int[] ans) {
        int idx = 0;
        ListNode p = head;
        while (p != null) {
            ans[idx++] = p.val;
            p = p.next;
        }
    }
}

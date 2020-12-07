package LC0_200.LC100_150;

import LeetCodeUtils.ListNode;
import LeetCodeUtils.TreeNode;

public class LC109_Convert_Sorted_List_To_Binary_Search_Tree {

    private ListNode head;
    private int findSize(ListNode head){
        if(head == null) return 0;
        ListNode fast = head, slow = head;
        int res = 0;
        while(fast != null){
            fast = fast.next;
            ++res;
        }
        return res;
    }

    private TreeNode covertListToBST(int low, int high){

        if(low > high) return null;
        int mid = (low + high) / 2;
        TreeNode left = covertListToBST(low, mid - 1);
        TreeNode node = new TreeNode(this.head.val);
        node.left = left;
        this.head = head.next;
        node.right = covertListToBST(mid + 1, high);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int size = this.findSize(head);
        this.head = head;
        return covertListToBST(0, size - 1);
    }
}

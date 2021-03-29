package LC1200_1400.LC1350_1400;

import LeetCodeUtils.ListNode;
import LeetCodeUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC1367_Linked_List_In_Binary_Tree {

    List<TreeNode> storingList = new ArrayList();
    public boolean isSubPath(ListNode head, TreeNode root) {
        storeToList(head, root);
        for (TreeNode element: storingList){
            if (checkSubPath(head, element))
                return true;
        }
        return false;
    }
    public void storeToList(ListNode head, TreeNode node){
        if (head == null || node == null)
            return;
        if (head.val == node.val)
            storingList.add(node);
        storeToList(head, node.left);
        storeToList(head, node.right);
    }
    public boolean checkSubPath(ListNode head, TreeNode node){
        if (head == null)
            return true;
        if (node == null)
            return false;
        if (head.val == node.val)
            return (checkSubPath(head.next, node.left) || checkSubPath(head.next, node.right));
        return false;
    }

}

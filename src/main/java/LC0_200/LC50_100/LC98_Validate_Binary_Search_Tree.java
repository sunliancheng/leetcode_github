package LC0_200.LC50_100;

import LeetCodeUtils.TreeNode;

import java.util.Stack;

public class LC98_Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && pre.val >= root.val)
                return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}

package LC0_200.LC100_150;

import LeetCodeUtils.TreeNode;

public class LC110_Balanced_Binary_Tree {

    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left), right = helper(root.right);
        if (Math.abs(left - right) > 1 || left == -1 || right == -1)
            return -1;
        return 1 + Math.max(left, right);
    }

}

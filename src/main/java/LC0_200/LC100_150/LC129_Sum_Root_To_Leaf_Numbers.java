package LC0_200.LC100_150;

import LeetCodeUtils.TreeNode;

public class LC129_Sum_Root_To_Leaf_Numbers {

    int result = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int prev) {
        prev = prev * 10 + root.val;
        if (root.left == null && root.right == null)
            result += prev;

        if (root.left != null)
            dfs(root.left, prev);
        if (root.right != null)
            dfs(root.right, prev);
    }

}

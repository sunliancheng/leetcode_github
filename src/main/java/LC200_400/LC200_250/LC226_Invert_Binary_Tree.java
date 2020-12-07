package LC200_400.LC200_250;

import LeetCodeUtils.TreeNode;

public class LC226_Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;

    }
}

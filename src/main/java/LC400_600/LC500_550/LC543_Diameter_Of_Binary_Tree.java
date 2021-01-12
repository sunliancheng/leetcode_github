package LC400_600.LC500_550;

import LeetCodeUtils.TreeNode;

public class LC543_Diameter_Of_Binary_Tree {

    public int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }

    public int helper(TreeNode node) {
        if (node == null)
            return 0;
        int l = helper(node.left), r = helper(node.right);
        diameter = Math.max(l + r, diameter);
        return Math.max(l, r) + 1;
    }

}

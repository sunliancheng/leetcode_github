package LC0_200.LC100_150;

import LeetCodeUtils.TreeNode;

public class LC111_Minimum_Depth_Of_Binary_Tree {

    public int depth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        findMin(root, 1);
        return depth;
    }

    public void findMin(TreeNode root, int level) {

        if (root != null) {
            if (level > depth)
                return;
            if (root.left == null && root.right == null) {
                depth = depth < level ? depth : level;
            }
            findMin(root.left, level + 1);
            findMin(root.right, level + 1);
        }
    }


}

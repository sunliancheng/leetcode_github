package LC0_200.LC100_150;

import LeetCodeUtils.TreeNode;

public class LC104_Maximum_Depth_Of_Binary_Tree {

    public int maxDepth(TreeNode root) {

        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }

}

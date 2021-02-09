package LC0_200.LC100_150;

import LeetCodeUtils.TreeNode;

public class LC124_Binary_Tree_Maximum_Path_Sum {

    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        /**
         *  1. 不经过root， value = Math.max(root.left, root.right)
         *  2. 经过root(root.val > 0), value = Math.max(root.left + root.val, root.right + root.val, root.right + root.left + root.val)
         *  3. 每个root跟新后的value代表的是经过他的最大值
         */
        maxPath(root);
        return maxValue;
    }

    public int maxPath(TreeNode root) {
        if (root == null) return -200000;
        //if (root.left == null && root.right == null) return root.val;
        int left = maxPath(root.left), right = maxPath(root.right);
        int val_left_root_right = left + right + root.val;
        int val_maxSub = Math.max(left, right);
        int val_leftOrRight_root = val_maxSub + root.val;

        int forInVal = Math.max(Math.max(val_left_root_right, val_leftOrRight_root), val_maxSub);
        int forOutVal = Math.max(val_leftOrRight_root, root.val);
        root.val = forOutVal;
        int temMax = Math.max(forInVal, forOutVal);
        maxValue = temMax > maxValue ? temMax : maxValue;
        return forOutVal;
    }

}

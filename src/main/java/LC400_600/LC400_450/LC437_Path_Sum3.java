package LC400_600.LC400_450;

import LeetCodeUtils.TreeNode;

public class LC437_Path_Sum3 {



    public int pathSum(TreeNode root, int sum) {
        return root != null ? pathSumStartWithRoot(root, sum)
                + pathSum(root.right, sum)
                + pathSum(root.left, sum) : 0;
    }

    int pathSumStartWithRoot(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int count = root.val == sum ? 1 : 0;
        count += pathSumStartWithRoot(root.left, sum - root.val);
        count += pathSumStartWithRoot(root.right, sum - root.val);
        return count;
    }

}

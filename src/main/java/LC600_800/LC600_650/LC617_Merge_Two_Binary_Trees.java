package LC600_800.LC600_650;

import LeetCodeUtils.TreeNode;

public class LC617_Merge_Two_Binary_Trees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        if (root1 == null)
            root1 = new TreeNode(root2.val);
        else
            if (root2 != null) root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2 == null ? null : root2.left);
        root1.right = mergeTrees(root1.right, root2 == null ? null : root2.right);
        return root1;
    }

}

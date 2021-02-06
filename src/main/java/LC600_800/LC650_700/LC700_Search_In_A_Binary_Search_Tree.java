package LC600_800.LC650_700;

import LeetCodeUtils.TreeNode;

public class LC700_Search_In_A_Binary_Search_Tree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val || root == null)
            return root;
        if (root.val > val)
            return searchBST(root.right, val);
        else
            return searchBST(root.left, val);
    }

}

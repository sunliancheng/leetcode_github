package LC0_200.LC100_150;

import LeetCodeUtils.TreeNode;

public class LC114_Flatten_Binary_Tree_To_Linked_List {

    TreeNode last = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        last = root;
        helper(root);
        exchange(root);
    }

    private void exchange(TreeNode root) {
        if (root.left != null) {
            root.right = root.left;
            root.left = null;
            exchange(root.right);
        }
    }

    public void helper(TreeNode root) {

        if (root.left != null) {
            last = root.left;
            helper(last);
        }
        if (root.right != null) {
            last.left = root.right;
            root.right = null;
            last = last.left;
            helper(last);
        }
    }
}

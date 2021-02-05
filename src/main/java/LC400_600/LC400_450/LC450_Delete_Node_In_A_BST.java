package LC400_600.LC400_450;

import LeetCodeUtils.TreeNode;

public class LC450_Delete_Node_In_A_BST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            int value = root.val;
            if (root.left != null && root.right != null) {
                TreeNode last = findMin(root.right);
                root.val = last.val;
                last.val = value;
                root.right = deleteNode(root.right, key);
            } else {
                if (root.left == null) root = root.right;
                else if (root.right == null) root = root.left;
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        if (root == null || root.left == null) return root;
        return findMin(root.left);
    }

}

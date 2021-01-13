package LC1000_1200.LC1050_1100;

import LeetCodeUtils.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC1100_Delete_Nodes_And_Return_Forest {

    public List<TreeNode> forest;
    public Set<Integer> set;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        forest = new ArrayList<>();
        set = new HashSet<>();
        for (int i : to_delete)
            set.add(i);
        root = helper(root);
        if (root != null)
            forest.add(root);
        return forest;
    }

    TreeNode helper (TreeNode root) {
        if (root == null)
            return root;
        root.right = helper(root.right);
        root.left = helper(root.left);
        if (set.contains(root.val)) {
            if (root.right != null)
                forest.add(root.right);
            if (root.left != null)
                forest.add(root.left);
            root = null;
        }
        return root;
    }



}

package LC200_400.LC200_250;

import LeetCodeUtils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class LC222_Count_Complete_Tree_Nodes {

    public int countNodes(TreeNode root) {
        return count(root);
    }

    public int count(TreeNode root) {
        if (root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }

}

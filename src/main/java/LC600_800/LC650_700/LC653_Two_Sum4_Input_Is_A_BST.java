package LC600_800.LC650_700;

import LeetCodeUtils.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *  2020-09-21 8:54AM at Hangzhou
 */
public class LC653_Two_Sum4_Input_Is_A_BST {

    public boolean findTarget(TreeNode root, int k) {

        HashSet<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
            if (set.contains(k - root.val))
                return true;
            set.add(root.val);
            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }
        return false;
    }

}

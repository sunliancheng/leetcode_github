package LC0_200.LC100_150;

import LeetCodeUtils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC107_Binary_Tree_Level_Order_Traversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        Deque<TreeNode> deque = new LinkedList();
        deque.addLast(root);
        while (deque.size() != 0) {
            int size = deque.size();
            List<Integer> tem = new ArrayList<>();
            while (--size >= 0) {
                TreeNode node = deque.removeFirst();
                tem.add(node.val);
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            ((LinkedList<List<Integer>>) result).addFirst(tem);
        }
        return result;
    }

}

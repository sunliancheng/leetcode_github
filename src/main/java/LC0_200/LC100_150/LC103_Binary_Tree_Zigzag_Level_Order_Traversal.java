package LC0_200.LC100_150;

import LeetCodeUtils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC103_Binary_Tree_Zigzag_Level_Order_Traversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        Deque<TreeNode> deque = new LinkedList();
        deque.addLast(root);
        boolean flag = true;
        while (deque.size() != 0) {
            int size = deque.size();
            LinkedList<Integer> tem = new LinkedList<>();
            while (--size >= 0) {
                TreeNode node = deque.removeFirst();
                if (flag)
                    tem.add(node.val);
                else
                    tem.addFirst(node.val);
                if (node.left != null) deque.addLast(node.left);
                if (node.right != null) deque.addLast(node.right);
            }
            result.add(tem);
            flag = flag == true ? false : true;
        }
        return result;
    }

}

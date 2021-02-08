package LC0_200.LC100_150;

import LeetCodeUtils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LC113_Path_Sum2 {

    LinkedList<TreeNode> deque = new LinkedList<>(); //头进尾出
    List<List<Integer>> result = new ArrayList<>();
    int val = 0;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return result;
        inOrderTraversal(root, targetSum);
        return result;
    }

    public void inOrderTraversal(TreeNode root, int target) {
        val += root.val;
        deque.addLast(root);
        if (root.left == null && root.right == null && target == val) {
            List<Integer> tem = new ArrayList<>();
            for (int i = 0; i < deque.size(); ++i) {
                tem.add(deque.get(i).val);
            }
            result.add(tem);
        }
        if (root.left != null) {
            inOrderTraversal(root.left, target);
        }
        if (root.right != null) {
            inOrderTraversal(root.right, target);
        }
        deque.removeLast();
        val -= root.val;
    }

}

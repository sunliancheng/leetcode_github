package LC600_800.LC600_650;

import LeetCodeUtils.TreeNode;

import java.util.*;

public class LC637_Average_Of_Levels_In_Binary_Tree {


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avg = new ArrayList<>();
        if (root == null)
            return avg;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.addLast(root);
        while (!dq.isEmpty()) {
            int count = dq.size();
            double sum = 0;
            for (int i = 0; i < count; ++i) {
                TreeNode node = dq.removeFirst();
                sum += node.val;
                if (node.left != null)
                    dq.addLast(node.left);
                if (node.right != null)
                    dq.addLast(node.right);
            }
            avg.add(sum / count);
        }
        return avg;
    }

    public void preorder(TreeNode head) {
        visit(head);
        preorder(head.left);
        preorder(head.right);
    }

    public void inorder(TreeNode head) {
        inorder(head.left);
        visit(head);
        inorder(head.right);
    }

    public void postorder(TreeNode head) {
        postorder(head.left);
        postorder(head.right);
        visit(head);
    }

    public void visit(TreeNode node) {

    }
}

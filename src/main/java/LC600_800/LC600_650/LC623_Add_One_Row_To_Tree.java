package LC600_800.LC600_650;

import LeetCodeUtils.TreeNode;

import java.util.LinkedList;

public class LC623_Add_One_Row_To_Tree {


    public TreeNode addOneRow(TreeNode root, int v, int d) {

        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        if (d == 1) {
            TreeNode head = new TreeNode(v);
            head.left = root;
            return head;
        }
        int level = 0;
        while (list.size() != 0) {
            ++level;
            int size = list.size();
            while (size-- != 0) {
                TreeNode node = list.removeFirst();
                if (node == null) continue;
                if (level == d - 1) {
                    TreeNode left = new TreeNode(v), right = new TreeNode(v);
                    left.left = node.left;
                    right.right = node.right;
                    node.left = left;
                    node.right = right;
                }
                list.addLast(node.left);
                list.addLast(node.right);
            }
            if (level == d - 1)
                return root;
        }
        return root;
    }
}

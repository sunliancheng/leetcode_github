package LC1000_1200.LC1150_1200;

import LeetCodeUtils.TreeNode;

import java.util.LinkedList;

public class LC1161_Maximum_Level_Sum_Of_A_Binary_Tree {

    public int maxLevelSum(TreeNode root) {
        int max = Integer.MIN_VALUE, level = 0, l = 0;

        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        while (list.size() != 0) {
            int size = list.size();
            int tem = 0;
            ++l;
            while (size-- != 0) {
                TreeNode node = list.removeFirst();
                tem += node.val;
                if (node.left != null) list.addLast(node.left);
                if (node.right != null) list.addLast(node.right);
            }
            if (tem > max) {
                max = tem;
                level = l;
            }
        }
        return level;
    }

}

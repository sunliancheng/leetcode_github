package LC400_600.LC400_450;

import LeetCodeUtils.TreeNode;

import java.util.Stack;

public class LC404_Sum_Of_Left_Leaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        int result = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tem = stack.pop();
            if (tem.right != null)
                stack.push(tem.right);
            if (tem.left != null) {
                stack.push(tem.left);
                if (tem.left.left == null && tem.left.right == null)
                    result += tem.left.val;
            }
        }
        return result;
    }
}

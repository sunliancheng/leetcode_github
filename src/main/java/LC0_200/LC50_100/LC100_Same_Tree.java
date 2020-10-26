package LC0_200.LC50_100;

import LeetCodeUtils.TreeNode;

import java.util.Stack;

public class LC100_Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //preorder traval
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.push(p); stack2.push(q);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            TreeNode node2 = stack2.pop();
            // get val
            if(node != null && node2 != null){
                stack.push(node.right);
                stack.push(node.left);
                stack2.push(node2.right);
                stack2.push(node2.left);
                if(node.val != node2.val) return false;
            } else if(node == null && node2 == null){

            } else {
                return false;
            }

        }
        return true;
    }
}

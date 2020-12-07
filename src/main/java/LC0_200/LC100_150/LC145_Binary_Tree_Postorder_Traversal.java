package LC0_200.LC100_150;

import LeetCodeUtils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC145_Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {

        LinkedList<Integer> result = new LinkedList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            result.addFirst(cur.val);
            if(cur.left != null){
                stack.push(cur.left);
            }
            if(cur.right != null){
                stack.push(cur.right);
            }
        }
        return result;
    }
}

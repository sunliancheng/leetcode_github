package LC0_200.LC100_150;

import LeetCodeUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144_Binary_Tree_Preorder_Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while( current != null || !stack.isEmpty()){
            while(current != null){
                result.add(current.val);
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }

        return result;
    }
}

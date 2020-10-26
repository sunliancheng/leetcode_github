package LC0_200.LC50_100;

import LeetCodeUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC94_Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while(cur != null || !stack.isEmpty()){

            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }

        }

        return result;
    }
}

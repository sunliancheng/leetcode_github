package LC200_400.LC200_250;

import LeetCodeUtils.TreeNode;

import java.util.Stack;

public class LC236_Lowest_Common_Ancestor_Of_A_Binary_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode parentQ = null, parentP = null;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        //double stack to iterate Binary tree by post order
        stack.push(root); nums.push(0);
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if(p == cur) parentP = cur;
            else if(q == cur) parentQ = cur;
            if(parentQ == parentP && parentP != null && parentQ != null) return parentQ;
            if(cur != null){
                //push left
                if(nums.peek() == 0){
                    stack.push(cur.left);
                    nums.push(0);
                }
                //left end, push right
                else if(nums.peek() == 1){
                    stack.push(cur.right);
                    nums.push(0);
                }
                //right end, pop and return parent
                else{
                    cur = stack.pop();
                    if(parentQ != null && cur == parentQ) parentQ = stack.peek();
                    if(parentP != null && cur == parentP) parentP = stack.peek();
                    nums.pop();
                    nums.push(nums.pop() + 1);
                }
            }
            //null, pop and return parent
            else{
                cur = stack.pop();
                if(parentQ != null && cur == parentQ) parentQ = stack.peek();
                if(parentP != null && cur == parentP) parentP = stack.peek();
                nums.pop();
                nums.push(nums.pop() + 1);
            }
        }
        return null;
    }
}

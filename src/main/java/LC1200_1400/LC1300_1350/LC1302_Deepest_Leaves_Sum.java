package LC1200_1400.LC1300_1350;

import LeetCodeUtils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC1302_Deepest_Leaves_Sum {

    public int height(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    public int deepestLeavesSum(TreeNode root)
    {
        int height  = height(root);
        if(root==null) return 0;
        int sum = 0;
        int maxDepth = 0;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int count = q.size();
            level++;
            for(int i = 0; i<count; i++){
                TreeNode curr = q.poll();
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
                if(curr.left ==null && curr.right==null && height==level)
                    sum+=curr.val;
            }
        }
        return sum;
    }

}

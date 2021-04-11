package LC1000_1200.LC1100_1150;

import LeetCodeUtils.TreeNode;

public class LC1145_Binary_Tree_Coloring_Game {

    int left;
    int right;
    int val;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        val = x;
        count(root);
        if(Math.max(Math.max(left,right),n-left-right-1)>n/2)
            return true;
        return false;
    }
    public int count(TreeNode node){
        if(node==null)
            return 0;
        int l = count(node.left);
        int r = count(node.right);

        if(node.val==val){
            left=l;
            right=r;
        }
        return l+r+1;
    }

}

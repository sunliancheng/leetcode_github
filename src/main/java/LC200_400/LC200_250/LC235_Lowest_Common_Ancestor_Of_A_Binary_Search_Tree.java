package LC200_400.LC200_250;

import LeetCodeUtils.TreeNode;

public class LC235_Lowest_Common_Ancestor_Of_A_Binary_Search_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while(cur != null){
            if((p.val > cur.val && q.val < cur.val) || (p.val < cur.val && q.val > cur.val)) return cur;
            if(p.val > cur.val && q.val > cur.val) cur = cur.right;
            else if(p.val < cur.val && q.val < cur.val) cur = cur.left;
            else break;
        }
        return cur;
    }
}

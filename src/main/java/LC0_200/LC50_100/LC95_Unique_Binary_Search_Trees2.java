package LC0_200.LC50_100;

import LeetCodeUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC95_Unique_Binary_Search_Trees2 {
    public List<TreeNode> generateTrees(int n) {

        ArrayList<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<TreeNode>();
        if(n == 0) return dp[0];

        dp[0].add(null);
        //the idea of using offset is so amazing
        for(int len = 1; len <= n; ++len){
            dp[len] = new ArrayList<TreeNode>();

            for(int root = 1; root <= len; ++root){
                int left = root - 1;
                int right = len - root;
                for(TreeNode leftTree : dp[left]){
                    for(TreeNode rightTree : dp[right]){
                        TreeNode treeRoot = new TreeNode(root);
                        treeRoot.left = leftTree;
                        treeRoot.right = clone(rightTree, root);
                        dp[len].add(treeRoot);
                    }
                }
            }
        }
        return dp[n];
    }

    //copy tree and add thier offset
    private TreeNode clone(TreeNode n, int offset){
        if(n == null) return null;
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }

    private TreeNode treeCopy(TreeNode root){
        if(root == null) return null;
        TreeNode newroot = new TreeNode(root.val);
        newroot.left = treeCopy(root.left);
        newroot.right = treeCopy(root.right);
        return newroot;
    }

    //return all list of nodes. low & high express the range
    public List<TreeNode> createTree(int low, int high){
        List<TreeNode> res = new ArrayList<>();
        if(low > high){
            res.add(null); return res;
        }else if(low == high){
            TreeNode temp = new TreeNode(low);
            res.add(temp); return res;
        }
        //try each node as root
        for(int i = low; i <= high; ++i){
            List<TreeNode> leftlists = createTree(low, i - 1);
            List<TreeNode> rightlists = createTree(i + 1, high);

            for(TreeNode left : leftlists){
                for(TreeNode right : rightlists){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }

}

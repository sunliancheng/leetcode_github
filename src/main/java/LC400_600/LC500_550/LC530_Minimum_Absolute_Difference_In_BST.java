package LC400_600.LC500_550;

import LeetCodeUtils.TreeNode;

import java.util.PriorityQueue;

public class LC530_Minimum_Absolute_Difference_In_BST {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        int prev = pq.poll(), min = Integer.MAX_VALUE;
        while (pq.size() > 0) {
            Integer poll = pq.poll();
            int val = poll - prev;
            prev = poll;
            min = min < val ? min : val;
        }
        return min;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        pq.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

}

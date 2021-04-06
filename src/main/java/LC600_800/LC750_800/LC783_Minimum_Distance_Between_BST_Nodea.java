package LC600_800.LC750_800;

import LeetCodeUtils.TreeNode;

import java.util.List;
import java.util.PriorityQueue;

public class LC783_Minimum_Distance_Between_BST_Nodea {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int minDiffInBST(TreeNode root) {

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

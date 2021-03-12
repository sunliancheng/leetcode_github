package LC200_400.LC300_350;

import LeetCodeUtils.MyPrint;
import LeetCodeUtils.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC337_House_Robber3 {

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(rob(root));
    }



    public int rob(TreeNode root) {
        Map<TreeNode, int[]> map = new HashMap<>();
        return Math.max(dfs(root, 1, map), dfs(root, 0, map));
    }

    public int dfs (TreeNode root, int canSteal, Map<TreeNode, int[]> memory) {
        int[] tem = memory.getOrDefault(root, new int[2]);
        if (tem[canSteal] != 0) return tem[canSteal];
        if (root == null || (root.left == null && root.right == null && canSteal == 0)) return 0;
        if (root.left == null && root.right == null && canSteal == 1) {
            tem[canSteal] = root.val;
            memory.put(root, tem);
            return root.val;
        }

        if (canSteal == 1) {
            int re =  root.val + dfs(root.left, 0, memory) + dfs(root.right, 0, memory);
            tem[canSteal] = re;
            memory.put(root, tem);
            return re;
        } else {
            int re = Math.max(dfs(root.left, 0, memory), dfs(root.left, 1, memory))
                    + Math.max(dfs(root.right, 0, memory), dfs(root.right, 1, memory));
            tem[canSteal] = re;
            memory.put(root, tem);
            return re;
        }
    }

    /**
     * The thief has found himself a new place for his thievery again.
     * There is only one entrance to this area, called the "root."
     * Besides the root, each house has one and only one parent house.
     * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
     * It will automatically contact the police if two directly-linked houses were broken into on the same night.
     *
     * Determine the maximum amount of money the thief can rob tonight without alerting the police.
     *
     * Example 1:
     *
     * Input: [3,2,3,null,3,null,1]
     *
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     *
     * Output: 7
     * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
     * Example 2:
     *
     * Input: [3,4,5,1,3,null,1]
     *
     *      3
     *     / \
     *    4   5
     *   / \   \
     *  1   3   1
     *
     * Output: 9
     * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
     */

}

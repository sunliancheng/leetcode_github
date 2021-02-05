package LC400_600.LC500_550;

import LeetCodeUtils.TreeNode;
import org.junit.Test;

import java.util.*;

public class LC501_Find_Mode_In_Binary_Search_Tree {

    @Test
    public void test() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.left.left = new TreeNode(2);
        root.right.left.right = new TreeNode(6);
        root.right.right = new TreeNode(9);
        //System.out.println(findMode(root));

        TreeNode rooot = TreeNode.createTree(4);
        findMode(root);

    }

    private int currCount;
    private int maxCount = 0;
    private int lastVal = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[] {};
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) return;
        dfs(node.left, result);
        currCount = node.val == lastVal ? currCount + 1 : 1;
        if (currCount == maxCount) {
            result.add(node.val);
        } else if (currCount > maxCount) {
            result.clear();
            result.add(node.val);
            maxCount = currCount;
        }
        lastVal = node.val;
        dfs(node.right, result);
    }


}

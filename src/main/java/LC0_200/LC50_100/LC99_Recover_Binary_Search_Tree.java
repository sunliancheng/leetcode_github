package LC0_200.LC50_100;

import LeetCodeUtils.TreeNode;
import org.junit.Test;

public class LC99_Recover_Binary_Search_Tree {

    @Test
    public void test() {
        TreeNode n68 = new TreeNode(68);
        TreeNode n41 = new TreeNode(41);
        TreeNode n_85 = new TreeNode(-85);
        TreeNode n_73 = new TreeNode(-73);
        TreeNode n_49 = new TreeNode(-49);
        TreeNode n_98 = new TreeNode(-98);
        TreeNode n_124 = new TreeNode(-124);
        //TreeNode n_33 = new TreeNode(-33);

        n68.left = n41; n41.left = n_85;
        n_85.left = n_73; n_85.right = n_49;
        n_73.left = n_98; n_98.left = n_124;


        recoverTree(n68);
        System.out.println(n68);
    }

    TreeNode bigger = new TreeNode(Integer.MIN_VALUE), smaller = new TreeNode(Integer.MAX_VALUE);
    boolean flag = false;
    public void recoverTree(TreeNode root) {
        //bigger.val = Integer.MIN_VALUE; smaller.val = Integer.MAX_VALUE;
        if (root == null || flag) return;
        int right = findMin(root.right);
        int left = findMax(root.left);
        if (root.val >= left && root.val <= right) {
            bigger = new TreeNode(Integer.MIN_VALUE);
            smaller = new TreeNode(Integer.MAX_VALUE);
            recoverTree(root.left);
            bigger = new TreeNode(Integer.MIN_VALUE);
            smaller = new TreeNode(Integer.MAX_VALUE);
            recoverTree(root.right);
        } else if (root.val < left && root.val > right) {
            int big = bigger.val;
            bigger.val = smaller.val;
            smaller.val = big;
            flag = true;
        } else if (root.val < left) {
            int big = bigger.val;
            bigger.val = root.val;
            root.val = big;
            flag = true;
        } else if (root.val > right){
            int small = smaller.val;
            smaller.val = root.val;
            root.val = small;
            flag = true;
        }
    }

    public int findMax(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if (left > right && left > root.val) bigger = bigger.val > root.left.val ? bigger : root.left;
        else if (right > left && right > root.val) bigger = bigger.val > root.right.val ? bigger : root.right;
        else bigger = bigger.val > root.val ? bigger : root;
        return Math.max(Math.max(left, right), root.val);
    }

    public int findMin(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        int left = findMin(root.left);
        int right = findMin(root.right);
        if (left < right && left < root.val) smaller = smaller.val < root.left.val ? smaller : root.left;
        else if (right < left && right < root.val) smaller = smaller.val < root.right.val ? smaller : root.right;
        else smaller = smaller.val < root.val ? smaller : root;
        return Math.min(Math.min(left, right), root.val);
    }


    /**
     * Input: [1,3,null,null,2]
     *
     *    1
     *   /
     *  3
     *   \
     *    2
     *
     * Output: [3,1,null,null,2]
     *
     *    3
     *   /
     *  1
     *   \
     *    2
     *
     *    Example 2:
     *
     * Input: [3,1,4,null,null,2]
     *
     *   3
     *  / \
     * 1   4
     *    /
     *   2
     *
     * Output: [2,1,4,null,null,3]
     *
     *   2
     *  / \
     * 1   4
     *    /
     *   3
     *
     */

}

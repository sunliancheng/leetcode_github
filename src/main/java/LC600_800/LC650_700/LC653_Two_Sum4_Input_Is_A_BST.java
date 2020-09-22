package LC600_800.LC650_700;

import LeetCodeUtils.TreeNode;

import java.util.*;

/**
 *  2020-09-21 8:54AM at Hangzhou
 */
public class LC653_Two_Sum4_Input_Is_A_BST {

    /**
     *  it is not the best solution
     *  the better solution is below this function
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget2(TreeNode root, int k) {

        HashSet<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (k < root.val && root.left != null) {
            queue.add(root.left);
        } else
            queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
            if (set.contains(k - root.val))
                return true;
            set.add(root.val);
            if (root.right != null)
                queue.add(root.right);
            if (root.left != null)
                queue.add(root.left);
        }
        return false;
    }


    /**
     *  it is so-called a better solution than the previous given function
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        TreeNode left = root, right = root;
        while (left != null && right != null) {
            int cur = left.val + right.val;
            if (cur > k) {
                left = left.left;
            } else if (cur < k) {

            } else {
                if (left != right)
                    return true;
                else {
                    left = left.left;
                }
            }
        }
        return false;
    }

}

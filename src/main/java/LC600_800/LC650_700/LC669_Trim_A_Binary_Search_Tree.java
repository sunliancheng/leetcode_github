package LC600_800.LC650_700;

import LeetCodeUtils.TreeNode;
import org.junit.Test;

public class LC669_Trim_A_Binary_Search_Tree {

    @Test
    public void test() {
        TreeNode root = TreeNode.createTree(3);
        root.val = 1;
        root.left.val = 0;
        trimBST(root, 1, 2);
    }

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val > high) return trimBST(root.left, low, high);
        if (root.val < low) return trimBST(root.right, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }



    public int removeNode(TreeNode parent, TreeNode node) {
        // 删除节点 = 找到左子树的最大值，交换该节点和最大值节点的值，删除最大值节点
        int ans = 0;
        TreeNode max = findMax(node.left);
        if (max == null) {
            // 说明它就是根节点 直接删除
            node = null;
        } else {
            node.val = max.val;
            max = null;
        }
        ans = node.val;
        return ans;
    }

    public TreeNode findMin(TreeNode root) {
        return null;
    }

    public TreeNode findMax(TreeNode root) {
        if (root == null)
            return null;
        if (root.right == null && root.left == null)
            return root;
        else if (root.right == null)
            return findMax(root.left);
        else
            return findMax(root.right);
    }
}

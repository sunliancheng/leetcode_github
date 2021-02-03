package LC600_800.LC650_700;

import LeetCodeUtils.TreeNode;
import org.junit.Test;

public class LC669_Trim_A_Binary_Search_Tree {

    @Test
    public void test() {
        trimBST(TreeNode.createTree(3), 1, 2);
    }


    public TreeNode trimBST(TreeNode root, int low, int high) {
        trim(root, low, high);
        return root;
    }

    public void trim(TreeNode root, int l, int h) {
        if (root == null)
            return;

        if (root.val >= l && root.val <= h) {
            trimBST(root.left, l, h);
            trimBST(root.right, l, h);
        } else if (root.val < l) {
            root.left = null;
            root = root.right;
            trim(root, l, h);
        } else if (root.val > h) {
            root.right = null;
            root = root.left;
            trim(root, l, h);
        }
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

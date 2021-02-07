package LC0_200.LC100_150;

import LeetCodeUtils.TreeNode;
import org.junit.Test;

public class LC106_Construct_Binary_Tree_From_Inorder_And_Postorder_Traversal {

    @Test
    public void test() {
        TreeNode treeNode = buildTree(new int[]{2,3,1}, new int[]{3,2,1});
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return createSubTree(0, postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    public TreeNode createSubTree(int is, int ie, int ps, int pe, int[] inorder, int[] postorder) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int inIdx = 0;
        for (int i = is; i <= ie; ++i) {
            if (root.val == inorder[i])
                inIdx = i;
        }
        root.left = createSubTree(is, inIdx - 1, ps, ps + inIdx - is - 1, inorder, postorder);
        root.right = createSubTree(inIdx + 1, ie, ps + inIdx - is, pe - 1, inorder, postorder);
        return root;
    }


}

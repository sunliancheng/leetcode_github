package LC0_200.LC100_150;

import LeetCodeUtils.TreeNode;
import org.junit.Test;

public class LC106_Construct_Binary_Tree_From_Inorder_And_Postorder_Traversal {

    @Test
    public void test() {
        TreeNode treeNode = buildTree(new int[]{2,3,1}, new int[]{3,2,1});
        System.out.println(treeNode);
    }

    TreeNode father = null;
    boolean flag = true;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return createSubTree(0, postorder.length - 1, inorder, postorder);
    }

    public TreeNode createSubTree(int ps, int pe, int[] inorder, int[] postorder) {
        if (pe < 0 || pe < ps) {
            return null;
        }
        int pe_val = postorder[pe], root_idx = find(inorder, postorder, pe);
        if (pe == ps) {
            return new TreeNode(pe_val);
        }
        int p0 = ps, p1 = find(postorder, inorder, root_idx - 1) + 1, p2 = pe - 1, p3 = pe;
        TreeNode root = new TreeNode(pe_val);
        if (flag) {
            flag = false;
            father = root;
        }
        root.left = createSubTree(p0, p1 - 1, inorder, postorder);
        root.right = createSubTree(p1, p2, inorder, postorder);
        return root;
    }

    public int find(int[] target, int[] source, int idx) {
        if (idx < 0 || idx >= source.length)
            return -1;
        int val = source[idx];
        for (int i = 0; i < target.length; ++i) {
            if (target[i] == val) {
                return i;
            }
        }
        return -1;
    }

}

package LC200_400.LC250_300;

import LeetCodeUtils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC257_Binary_Tree_Paths {

    @Test
    public void test() {
        TreeNode r1 = new TreeNode(1), r2 = new TreeNode(2), r3 = new TreeNode(3),
                r4 = new TreeNode(5);
        r1.left = r2; r1.right = r3;
        binaryTreePaths(r1);
    }

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null)
            dfs(root);
        return res;
    }

    void dfs(TreeNode root) {
        StringBuilder sbtem = new StringBuilder(sb);
        sb.append(root.val);
        StringBuilder sbtem2 = new StringBuilder(sb);
        sb.append("->");
        if (root.left != null)
            dfs(root.left);
        if (root.right != null)
            dfs(root.right);

        if (root.right == null && root.left == null) {
            sb = sbtem2;
            //System.out.println(sb.toString());
            res.add(sb.toString());
            sb = sbtem;
            return;
        }
        sb = sbtem;

    }

}

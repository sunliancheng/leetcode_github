package LC400_600.LC500_550;

import LeetCodeUtils.TreeNode;
import org.junit.Test;

public class LC513_FInd_Bottom_Left_Tree_Value {

    @Test
    public void test() {
        System.out.println(findBottomLeftValue(null));
    }

    int level = 0, result = 0;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        dfs(1, root);
        return result;
    }

    public void dfs(int depth, TreeNode root) {
        if (root.left == null && root.right == null) {
            if (depth > level) {
                level = depth;
                result = root.val;
            }
            return;
        }
        if (root.left != null) dfs(1 + depth, root.left);
        if (root.right != null) dfs(1 + depth, root.right);
    }

}

package LC800_1000.LC850_900;

import LeetCodeUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC872_Leaf_Similar_Trees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        dfs(root1, l1); dfs(root2, l2);
        return l1.equals(l2);

    }

    public void dfs (TreeNode root, List<Integer> list) {
        if (root.right == null && root.left == null) {
            list.add(root.val);
            return;
        }
        if (root.left != null) dfs(root.left, list);
        if (root.right != null) dfs(root.right, list);
    }

}

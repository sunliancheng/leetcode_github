package LC400_600.LC500_550;

import LeetCodeUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC515_Find_Largest_Value_In_Each_Tree_Row {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) dfs(0, result, root);
        return result;
    }

    public void dfs(int level, List<Integer> ans, TreeNode node) {
        if (ans.size() <= level) {
            ans.add(node.val);
        } else {
            if (ans.get(level) < node.val) {
                ans.set(level, node.val);
            }
        }
        if (node.left != null) dfs(1 + level, ans, node.left);
        if (node.right != null) dfs(1 + level, ans, node.right);
    }



}

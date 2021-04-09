package LC800_1000.LC950_1000;

import LeetCodeUtils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC988_Smallest_String_Starting_From_Leaf {

    @Test
    public void test() {
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(2);
        System.out.println(smallestFromLeaf(root));
    }

    public String smallestFromLeaf(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, new StringBuilder(), result);
        Collections.sort(result);
        return result.get(0);
    }

    public void dfs(TreeNode root, StringBuilder sb, List<String> list) {
        sb.append((char) (root.val + 'a'));
        if (root.left == null && root.right == null) {
            list.add(sb.reverse().toString());
            sb.reverse();
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        if (root.left != null) dfs(root.left, sb, list);
        if (root.right != null) dfs(root.right, sb, list);
        sb.deleteCharAt(sb.length() - 1);
    }

}

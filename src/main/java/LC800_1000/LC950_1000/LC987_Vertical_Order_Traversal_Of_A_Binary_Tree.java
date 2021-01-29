package LC800_1000.LC950_1000;

import LeetCodeUtils.TreeNode;
import org.junit.Test;

import java.util.*;

public class LC987_Vertical_Order_Traversal_Of_A_Binary_Tree {

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
    }




    List<Points> list = null;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        traversal(root, 0, 0);

        list.sort((Points o1, Points o2) -> {
            if (o1.x == o2.x)
                return o2.y - o1.y;
            return o2.x - o1.x;
        });

        int prev = 0, i = 0;
        while (i < list.size()) {
            Points current = list.get(i);
            if (current.x == prev) {
                result.get(result.size() - 1).add(current.val);
            } else {
                List<Integer> tem = new ArrayList<>();
                tem.add(current.val);
                result.add(tem);
            }
            prev = current.x;
        }
        return result;
    }

    public void traversal(TreeNode node, int x, int y) {
        if (node == null)
            return;
        list.add(new Points(x, y, node.val));
        traversal(node.left, x - 1, y - 1);
        traversal(node.right, x + 1, y - 1);
    }


    class Points {
        int x, y, val;

        Points(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

}

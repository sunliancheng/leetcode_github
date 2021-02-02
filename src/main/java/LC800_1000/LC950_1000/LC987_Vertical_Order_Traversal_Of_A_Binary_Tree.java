package LC800_1000.LC950_1000;

import LeetCodeUtils.Node;
import LeetCodeUtils.TreeNode;
import org.junit.Test;

import java.util.*;

public class LC987_Vertical_Order_Traversal_Of_A_Binary_Tree {

    /**
     * (x, y)  --> (y, x)
     */

    @Test
    public void test() {
        TreeNode root = TreeNode.createTree(7);
        List<List<Integer>> lists = verticalTraversal(root);
        for (List<Integer> ls : lists) {
            for (int i : ls) {
                System.out.print(" " + i);
            }
            System.out.println(" ");
        }
    }




    List<Points> list = null;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        traversal(root, 0, 0, null);

        list.sort((Points o1, Points o2) -> {
            if (o1.y == o2.y) {
                if (o1.x == o2.x) {
                    return o1.val - o2.val;
                } else
                    return o1.x - o2.x;
            }
            return o1.y - o2.y;
        });

        int prev = Integer.MAX_VALUE, i = 0;
        while (i < list.size()) {
            Points current = list.get(i);
            if (current.y == prev) {
                result.get(result.size() - 1).add(current.val);
            } else {
                List<Integer> tem = new ArrayList<>();
                tem.add(current.val);
                result.add(tem);
            }
            prev = current.y;
            ++i;
        }
        return result;
    }

    public void traversal(TreeNode node, int y, int x, Points father) {
        if (node == null)
            return;
        Points tem = new Points(y, x, node.val, father);
        list.add(new Points(y, x, node.val, father));
        traversal(node.left, y + 1, x - 1, tem);
        traversal(node.right, y + 1, x + 1, tem);
    }


    class Points {
        int x, y, val;
        Points father = null;

        Points(int x, int y, int val, Points father) {
            this.x = x;
            this.y = y;
            this.val = val;
            this.father = father;
        }

    }

}

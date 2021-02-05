package LC800_1000.LC950_1000;

import LeetCodeUtils.TreeNode;

import java.util.*;

public class LC993_Cousins_In_Binary_Tree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Deque<TreeNode> deque = new LinkedList<>();
        // to record level order traversal result, <value, index>
        Map<Integer, Integer> map = new HashMap<>();
        deque.addLast(root);
        while (deque.size() != 0) {
            int size = deque.size(), i = 0;
            while (--size >= 0) {
                TreeNode tem = deque.removeFirst();
                map.put(tem == null ? Integer.MAX_VALUE : tem.val, i++);
                if (tem != null) {
                    deque.addLast(tem.left);
                    deque.addLast(tem.right);
                }
            }
            int idx1 = map.getOrDefault(x, -1);
            int idx2 = map.getOrDefault(y, -1);
            if (idx1 / 2 != idx2 / 2 && idx1 != -1 && idx2 != -1)
                return true;
            map.clear();
        }
        return false;
    }

}

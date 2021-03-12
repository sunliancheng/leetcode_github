package LC0_200.LC100_150;

import LeetCodeUtils.Node;

import java.util.HashMap;
import java.util.Map;

public class LC117_Populating_Next_Pointers_In_Each_Node2 {

    public Node connect(Node root) {
        dfs(root, new HashMap<>(), 1);
        return root;
    }

    public void dfs(Node root, Map<Integer, Node> map, int depth) {
        if (root == null) return;
        Node prev = map.getOrDefault(depth, null);
        if (prev != null) prev.next = root;
        map.put(depth, root);
        dfs(root.left, map, 1 + depth);
        dfs(root.right, map, 1 + depth);
    }

}

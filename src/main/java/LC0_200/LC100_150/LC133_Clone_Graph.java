package LC0_200.LC100_150;

import LeetCodeUtils.Node;
import org.junit.Test;

import java.util.*;

public class LC133_Clone_Graph {

    @Test
    public void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        Node result = cloneGraph(node1);
        System.out.println(result);
    }

    public Set<Integer> set = new HashSet<>();
    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return clone(map, node);
    }

    public Node clone(Map<Integer, Node> map, Node node) {

        if (map.containsKey(node.val))
            return map.get(node.val);

        Node nodeK = new Node(node.val);
        map.put(nodeK.val, nodeK);
        List<Node> neighbors = node.neighbors;
        for (Node temp : neighbors) {
            Node result = clone(map, temp);
            nodeK.neighbors.add(result);
            if (!set.contains(result.val))
                result.neighbors.add(nodeK);
        }
        set.add(node.val);
        return nodeK;
    }

}

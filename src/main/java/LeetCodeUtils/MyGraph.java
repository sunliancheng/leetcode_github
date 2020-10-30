package LeetCodeUtils;

import javafx.util.Pair;

import java.util.*;
import java.util.Map.Entry;

/**
 * this class is a not formal Graph defined in the text book,
 * as I use hashmap rather than linkedlist
 * note that: all nodes are unique
 */
public class MyGraph {

    public static class GNode {
        public String name;
        HashMap<GNode, Double> map;
    }

    public static HashMap<String, GNode> allNodeMap = new HashMap<>();

    public static HashMap<String, GNode> createGraph(List<List<String>> expressions, double[] weights) {

        for (int i = 0; i < expressions.size(); ++i) {
            List<String> ls = expressions.get(i);
            double weight = weights[i];
            String node_name1 = ls.get(0); String node_name2 = ls.get(1);
            GNode node1, node2;
            if (!allNodeMap.containsKey(node_name1))
                node1 = createNode(node_name1);
            else
                node1 = allNodeMap.get(node_name1);
            if (!allNodeMap.containsKey(node_name2))
                node2 = createNode(node_name2);
            else
                node2 = allNodeMap.get(node_name2);

            if (!node1.map.containsKey(node2))
                node1.map.put(node2, weight);
            if (!node2.map.containsKey(node1))
                node2.map.put(node1, 1 / weight);
        }
        return allNodeMap;
    }

    /**
     * if there is no node in map, the createNode function will be executed
     * @param name
     */
    public static GNode createNode(String name) {
        GNode node = new GNode();
        node.name = name;
        node.map = new HashMap<>();
        allNodeMap.put(name, node);
        return node;
    }

    private static double min_dis = Double.MAX_VALUE;

    /**
     *
     *  Notice: this function is not actually calculate the distance,
     *  not the sum of distances, it is the multiple of distances
     *  if use return : just find a way no matter whether it is the smallest way
     * @param a
     * @param b
     * @return
     */
    public static void recursive(GNode original, GNode target, double curDis, HashMap<GNode, Boolean> isVisited) {
        if (isVisited.get(original) != null && isVisited.get(original))
            return;
        if (!allNodeMap.containsKey(original.name) || !allNodeMap.containsKey(target.name))
            return;
        if (original.map.containsKey(target)) {
            double temp = (curDis == 0 ? original.map.get(target) : original.map.get(target) * curDis);
            min_dis = min_dis < temp ? min_dis : temp;
            return;
        }
        isVisited.put(original, true);
        Set<Entry<GNode, Double>> entrys = original.map.entrySet();
        for (Entry<GNode, Double> entry : entrys) {
                recursive(entry.getKey(), target, (curDis == 0 ? entry.getValue() : curDis * entry.getValue()), isVisited);
        }
    }

    public static double calDistanceOf2Node(String original, String target) {
        min_dis = Double.MAX_VALUE;
        HashMap<GNode, Boolean> isvisited = new HashMap<>();
        if (!allNodeMap.containsKey(original) || !allNodeMap.containsKey(target))
            return -1.0;
        if (original.equals(target))
            return 1.0;
        recursive(allNodeMap.get(original), allNodeMap.get(target), 0, isvisited);
        if (min_dis == Double.MAX_VALUE)
            return -1.0;
        return min_dis;
    }
}

package LC200_400.LC350_400;

import LeetCodeUtils.MyGraph;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * 2020-09-28 10:11 AM at Hangzhou
 */
public class LC399_Evaluate_Division {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String, MyGraph.GNode> allNodeMap = MyGraph.createGraph(equations, values);

        double[] result = new double[queries.size()];
        int i = 0;
        for (List<String> ls : queries) {
            double dis = MyGraph.calDistanceOf2Node(ls.get(0), ls.get(1));
            result[i++] = dis;
        }
        return result;
    }

    @Test
    public void test() {
        List<List<String>> ls = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("a"); l1.add("b"); ls.add(l1);
        List<String> l2 = new ArrayList<>();
        l2.add("b"); l2.add("c"); ls.add(l2);
        List<String> l3 = new ArrayList<>();
        l3.add("bc"); l3.add("cd"); ls.add(l3);

        List<List<String>> query = new ArrayList<>();
        List<String> l = new ArrayList<>();
        l.add("bc"); l.add("cd"); query.add(l);
        double[] arr = (calcEquation(ls, new double[]{1.5, 2.5, 5.0}, query));
        for (double jj : arr)
            System.out.println(jj);
    }

    /**
     * You are given equations in the format A / B = k, where A and B are variables represented as strings,
     * and k is a real number (floating-point number). Given some queries, return the answers.
     * If the answer does not exist, return -1.0.
     *
     * The input is always valid. You may assume that evaluating the queries will result in no division by zero
     * and there is no contradiction.
     *
     * Example 1:
     *
     * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
     * Explanation:
     * Given: a / b = 2.0, b / c = 3.0
     * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
     * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
     * Example 2:
     *
     * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
     * Output: [3.75000,0.40000,5.00000,0.20000]
     *
     *
     * [["a","e"],["b","e"]]
     * [4.0,3.0]
     * [["a","b"],["e","e"],["x","x"]]
     */
}

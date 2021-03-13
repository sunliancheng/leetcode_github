package LeetCodeUtils;

import com.alibaba.fastjson.util.IdentityHashMap;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node child;
    public Node prev;
    public List<Node> children;
    public List<Node> neighbors;
    public Node random;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
        this.neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

}

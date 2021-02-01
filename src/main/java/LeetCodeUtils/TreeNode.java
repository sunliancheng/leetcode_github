package LeetCodeUtils;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     *  Using level traverse to create Tree
     *  eg. "3,4,5,6,null,null,null";
     * @return
     */
    public TreeNode createTreeByLevelTraverse(String s) {
        String[] strs = s.split(",");
        Deque<TreeNode> deque = new LinkedList<>();
        Deque<TreeNode> currentLevel = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(i);
        deque.addLast(root);
        while (++i < strs.length) {
            TreeNode father = deque.getFirst();
            TreeNode left = new TreeNode(i);
            father.left = left;
            if (++i < strs.length) {
                TreeNode right = new TreeNode(++i);
                father.right = right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = createTree(3);
        System.out.println(tree.val);
        System.out.println(tree.left.val);
        System.out.println(tree.right.val);
        System.out.println(tree.left.left.val);
    }

    public static TreeNode createTree(int len) {
        Deque<TreeNode> deque = new LinkedList<>();
        int i = 0;
        TreeNode root = new TreeNode(i);
        deque.addLast(root);
        while (++i < len) {
            TreeNode father = deque.getFirst();
            TreeNode left = new TreeNode(i);
            father.left = left;
            if (++i < len) {
                TreeNode right = new TreeNode(i);
                father.right = right;
            }
        }
        return root;
    }

}
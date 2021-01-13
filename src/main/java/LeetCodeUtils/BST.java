package LeetCodeUtils;

import java.util.PriorityQueue;

public class BST {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {return o2 - o1;});
        pq.add(1); pq.add(0); pq.add(3);
        System.out.println(pq.poll());
        StringBuffer sb = new StringBuffer();
    }

    TreeNode root;

    TreeNode makeEmpty(TreeNode t) {
        if (t == null) return null;
        makeEmpty(t.left);
        makeEmpty(t.right);
        t = null;
        return null;
    }

    TreeNode insert(TreeNode t, int val) {
        if (t == null) {
            t = new TreeNode(val);
        } else if (val < t.val) {
            t.left = insert(t.left, val);
        } else if (val > t.val) {
            t.right = insert(t.right, val);
        }
        return t;
    }

    TreeNode find(TreeNode t, int val) {
        if (t == null) return null;
        if (val < t.val) {
            return find(t.left, val);
        } else if (val > t.val) {
            return find(t.right, val);
        }
        return t;
    }

    TreeNode findMin(TreeNode t) {
        if (t == null || t.left == null) return t;
        return findMin(t.left);
    }

    TreeNode findMax(TreeNode t) {
        if (t == null || t.right == null) return t;
        return findMax(t);
    }

    TreeNode remove(TreeNode t, int val) {
        TreeNode temp;
        if (t == null) return null;
        else if (val < t.val) t.left = remove(t.left, val);
        else if (val > t.val) t.right = remove(t.right, val);
        else if (t.left != null && t.right != null) {
            temp = findMin(t.right);
            t.val = temp.val;
            t.right = remove(t.right, t.val);
        } else {
            temp = t;
            if (t.left == null) t = t.right;
            else if (t.right == null) t = t.left;
            temp = null;
        }
        return t;
    }

    public BST() {
        root = null;
    }

    void insert(int v) { insert(root, v); }

    void remove(int v) { remove(root, v); }



}


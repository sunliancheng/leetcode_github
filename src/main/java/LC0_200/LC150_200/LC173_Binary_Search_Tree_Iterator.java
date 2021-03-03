package LC0_200.LC150_200;

import LeetCodeUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC173_Binary_Search_Tree_Iterator {

}

class BSTIterator {

    List<Integer> list = null;
    int i = 0;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
    }

    public int next() {
        if (i < list.size()) {
            return list.get(i++);
        } else
            return -1;
    }

    public boolean hasNext() {
        if (i < list.size())
            return true;
        return false;
    }

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
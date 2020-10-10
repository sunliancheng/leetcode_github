package LeetCodeUtils;

import org.junit.Test;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
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
        return null;
    }

    @Test
    public void test() {

    }


}
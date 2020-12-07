package LC200_400.LC200_250;

import LeetCodeUtils.TreeNode;

import java.util.Stack;

public class LC230_Kth_Smallest_Element_In_A_BST {
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty()) {
            while(root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(--k == 0)
                return root.val;
            root = root.right;
        }
        return -1;
    }
}

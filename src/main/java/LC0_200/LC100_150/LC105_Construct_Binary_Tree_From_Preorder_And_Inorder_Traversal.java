package LC0_200.LC100_150;

import LeetCodeUtils.TreeNode;

import java.util.HashMap;

public class LC105_Construct_Binary_Tree_From_Preorder_And_Inorder_Traversal {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i)
            map.put(inorder[i], i);
        return buildTreeHelper(map, preorder, 0, preorder.length - 1, 0);
    }

    private TreeNode buildTreeHelper(HashMap<Integer, Integer> map, int[] preorder, int s0, int e0, int s1) {
        if (s0 > e0)
            return null;
        int mid = preorder[s1], idx = map.get(mid), leftLen = idx - s0 - 1;
        TreeNode node = new TreeNode(mid);
        node.left = buildTreeHelper(map, preorder, s0, idx - 1, s1 + 1);
        node.right = buildTreeHelper(map, preorder, idx + 1, e0, s1 + 2 + leftLen);
        return node;
    }

}

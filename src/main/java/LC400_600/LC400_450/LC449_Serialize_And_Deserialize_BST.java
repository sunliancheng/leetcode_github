package LC400_600.LC400_450;

import LeetCodeUtils.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class LC449_Serialize_And_Deserialize_BST {

    @Test
    public void test() {
        System.out.println(serialize(deserialize("2 1 3")));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder("");
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while (q.size() > 0) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("n ");
                continue;
            }
            sb.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;
        String[] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        for (int i = 1; i < nodes.length; ++i) {
            TreeNode parent = q.poll();
            if (!nodes[i].equals("n")) {
                parent.left = new TreeNode(Integer.valueOf(nodes[i]));
                q.add(parent.left);
            }
            ++i;
            if (i < nodes.length && !nodes[i].equals("n")) {
                parent.right = new TreeNode(Integer.valueOf(nodes[i]));
                q.add(parent.right);
            }
        }
        return root;
    }

    /**
     *  449. Serialize and Deserialize BST
     * Serialization is converting a data structure or object into a sequence of bits
     * so that it can be stored in a file or memory buffer,
     * or transmitted across a network connection link to be reconstructed later
     * in the same or another computer environment.
     *
     * Design an algorithm to serialize and deserialize a binary search tree.
     * There is no restriction on how your serialization/deserialization algorithm should work.
     * You need to ensure that a binary search tree can be serialized to a string,
     * and this string can be deserialized to the original tree structure
     *
     * Example 1:
     *
     * Input: root = [2,1,3]
     * Output: [2,1,3]
     * Example 2:
     *
     * Input: root = []
     * Output: []
     */
}

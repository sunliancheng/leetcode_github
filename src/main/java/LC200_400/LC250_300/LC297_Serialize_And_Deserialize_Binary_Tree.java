package LC200_400.LC250_300;

import LeetCodeUtils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC297_Serialize_And_Deserialize_Binary_Tree {
    private static final String spliter = ",";
    private static final String NN = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        Queue<TreeNode> treeQ = new LinkedList<>();
        StringBuilder sb = new StringBuilder("");
        treeQ.offer(root);
        while(!treeQ.isEmpty()){
            TreeNode cur = treeQ.poll();
            if(cur != null){
                sb.append(cur.val); sb.append(spliter);
                treeQ.offer(cur.left);
                treeQ.offer(cur.right);
            } else
                sb.append(NN); sb.append(spliter);
        }
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] nodes = data.split(spliter);
        int flag = 1; int count = 0;
        for(int i = nodes.length - 1; i >= 0; i--) {
            if(flag == 1) {
                if(nodes[i].equals("X")) count++;
                else flag = 2;
            } else break;
        }
        TreeNode result = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> treeNode = new LinkedList<>();
        treeNode.offer(result);

        for(int i = 1; i <= nodes.length - 1 - count; i++) {
            TreeNode parent = treeNode.poll();
            if(!nodes[i].equals("X")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                parent.left = left;
                treeNode.offer(left);
            }
            if(!nodes[++i].equals("X")) {
                TreeNode r = new TreeNode(Integer.parseInt(nodes[i]));
                parent.right = r;
                treeNode.offer(r);
            }
        }
        return result;
    }
}

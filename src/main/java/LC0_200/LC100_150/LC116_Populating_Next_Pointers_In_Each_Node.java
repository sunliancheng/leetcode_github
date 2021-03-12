package LC0_200.LC100_150;

import LeetCodeUtils.Node;
import LeetCodeUtils.TreeNode;

import java.util.LinkedList;

public class LC116_Populating_Next_Pointers_In_Each_Node {

    public Node connect(Node root) {
        if (root == null) return null;
        LinkedList<Node> list = new LinkedList<>();
        list.addLast(root);
        while (list.size() != 0) {
            int size = list.size();
            while (--size >= 0) {
                Node tem = list.removeFirst();
                if(tem.left != null) list.addLast(tem.left);
                if(tem.right != null) list.addLast(tem.right);
                if (size == 0) tem.next = null;
                else tem.next = list.get(0);
            }
        }
        return root;
    }

}

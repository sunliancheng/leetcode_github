package LC400_600.LC400_450;

import LeetCodeUtils.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC429_N_ary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int len = queue.size();
            //find all element in the stack, and add to result
            for(int i = 0; i <= len - 1; i++){
                Node cur = queue.poll();
                temp.add(cur.val);
                for(Node node : cur.children){
                    queue.offer(node);
                }
            }
            result.add(temp);
        }// end while

        return result;
    }
}

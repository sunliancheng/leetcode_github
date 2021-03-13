package LC400_600.LC400_450;

import LeetCodeUtils.Node;
import java.util.LinkedList;

public class LC430_Flatten_A_Multilevel_Doubly_Linked_List {

    public Node flatten(Node head) {
        if (head == null) return null;
        LinkedList<Node> list = new LinkedList<>();
        list.addFirst(head);
        Node prev = head;
        while (list.size() > 0) {
            Node tem = list.removeFirst();
            if (tem.next != null) list.addFirst(tem.next);
            if (tem.child != null) list.addFirst(tem.child);
            if (tem != head) {
                prev.next = tem;
                tem.prev = prev;
                prev.child = null;
                prev = tem;
            }
        }
        return head;
    }



}

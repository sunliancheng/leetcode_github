package LC0_200.LC100_150;

public class LC138_Copy_List_With_Random_Pointer {
    public Node copyRandomList(Node head) {

        Node iter = head;
        Node next;
        while(iter != null){
            next = iter.next;
            Node new_node = new Node(iter.val);
            iter.next = new_node;
            new_node.next = next;
            iter = next;
        }
        //assign random pointers
        iter = head;
        while(iter != null){
            if(iter.random != null){
                //random.next must need an exact node
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }
        Node new_head = new Node(0);
        iter = head;
        Node copy, copyIter = new_head;
        while(iter != null){
            next = iter.next.next;
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;
            iter.next = next;
            iter = next;
        }
        return new_head.next;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

package LC200_400.LC200_250;

import LeetCodeUtils.ListNode;

public class LC206_Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fin;
        for(fin = head; fin.next != null; fin = fin.next){

        }

        for(ListNode p = head; p != fin; p = p.next){
            insert(p, fin);
        }

        return fin;
    }

    //insert into first
    public void insert(ListNode node, ListNode fin){
        ListNode ne = new ListNode(node.val);
        ne.next = fin.next;
        fin.next = ne;
    }
}

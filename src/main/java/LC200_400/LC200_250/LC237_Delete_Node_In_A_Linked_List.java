package LC200_400.LC200_250;

import LeetCodeUtils.ListNode;

public class LC237_Delete_Node_In_A_Linked_List {
    public void deleteNode(ListNode node) {
        //shit, it's a wired question
        node.val=node.next.val;
        node.next=node.next.next;
    }
}

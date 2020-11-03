package LC0_200.LC100_150;

import LeetCodeUtils.ListNode;

public class LC147_Insertion_Sort_List {

    public ListNode insertionSortList(ListNode head) {

        ListNode pseudoHead = new ListNode();
        ListNode curr = head, prevNode, nextNode;

        while (curr != null) {
            prevNode = pseudoHead;
            nextNode = pseudoHead.next;

            while (nextNode != null) {
                if (curr.val < nextNode.val)
                    break;
                prevNode = nextNode;
                nextNode = nextNode.next;
            }

            ListNode nextIter = curr.next;
            curr.next = nextNode;
            prevNode.next = curr;
            curr = nextIter;
        }
        return pseudoHead.next;
    }

}

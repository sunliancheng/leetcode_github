package LC0_200.LC100_150;

import LeetCodeUtils.ListNode;

public class LC141_Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while(fast != null && slow != null){

            if(fast == slow)
                count += 1;
            if(count == 2)
                return true;
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next.next;
            }else
                break;
        }
        return false;

    }
}

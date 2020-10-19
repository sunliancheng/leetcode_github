package LC0_200.LC0_50;

import LeetCodeUtils.ListNode;

public class LC21_Merge_Two_Sorted_Lists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode finall = result;

        ListNode p = l1, q = l2;

        while(p != null || q != null){
            if(p != null && q != null){
                ListNode temp = new ListNode();
                if(p.val < q.val){
                    temp.val = p.val;
                    finall.next = temp;
                    finall = finall.next;
                    p = p.next;
                }else{
                    temp.val = q.val;
                    finall.next = temp;
                    finall = finall.next;
                    q = q.next;
                }
            }
            else if(p != null){
                ListNode temp = new ListNode();
                temp.val = p.val;
                finall.next = temp;
                finall = finall.next;
                p = p.next;
            }else{
                ListNode temp = new ListNode();
                temp.val = q.val;
                finall.next = temp;
                finall = finall.next;
                q = q.next;
            }
        }

        return result.next;
    }
}

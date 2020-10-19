package LC0_200.LC0_50;

import LeetCodeUtils.ListNode;

public class LC23_Merge_K_Sorted_Liksts {
    public ListNode mergeKLists(ListNode[] lists) {
        //if I define like below, I will introduce "0" element
        //ListNode result = new ListNode();
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];

        //the way that merge works is slow, so how to optimize the way that merge works
        // ListNode result = merge2Lists(lists[0], lists[1]);
        // for(int i  = 2; i <= lists.length - 1; ++i){
        //     result = merge2Lists(result, lists[i]);
        // }
        //return result;

        //just testify whether I still know how to divide and conquer
        int interval = 1;
        while(interval < lists.length){
            for(int i = 0; i + interval < lists.length; i += interval*2){
                lists[i] = merge2Lists(lists[i], lists[i + interval]);

            }
            interval *= 2;
        }
        return lists[0];

        //interval, its an amazing solution, and interval is the key of "divide and conquer"
        // int interval = 1;
        // while(interval < lists.length){
        //     for(int i = 0; i + interval < lists.length; i += interval * 2)
        //         lists[i] = merge2Lists(lists[i], lists[i + interval]);
        //     interval *= 2;
        // }
        // return lists[0];
    }
    public ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode result = new ListNode();
        ListNode finall = result;
        ListNode p = l1, q = l2;
        while(p != null || q != null){
            //q != null
            if(p != null && q != null){
                ListNode temp = new ListNode();
                if(p.val < q.val){
                    temp.val = p.val; finall.next = temp; finall = temp; p = p.next;
                }else{
                    temp.val = q.val; finall.next = temp; finall = temp; q = q.next;
                }
            }else if(p != null){
                ListNode temp = new ListNode();
                temp.val = p.val; finall.next = temp; finall = temp; p = p.next;
            }else{
                ListNode temp = new ListNode();
                temp.val = q.val; finall.next = temp; finall = temp; q = q.next;
            }
        }
        return result.next;
        //         if(l1 == null && l2 == null) return null;
//         else if(l1 == null) return l2;
//         else if(l2 == null) return l1;

//         ListNode result = new ListNode();
//         ListNode finall = result;

//         ListNode p = l1, q = l2;
//         while(p != null || q != null){
//             if(p != null && q != null){
//                 ListNode temp = new ListNode();
//                 if(p.val < q.val){
//                     temp.val = p.val;
//                     p = p.next;
//                     finall.next = temp;
//                     finall = finall.next;
//                 }else{
//                     temp.val = q.val;
//                     q = q.next;
//                     finall.next = temp;
//                     finall = finall.next;
//                 }
//             }else if(p != null){
//                 ListNode temp = new ListNode();
//                 temp.val = p.val;
//                 p = p.next;
//                 finall.next = temp;
//                 finall = finall.next;
//             }else{
//                 ListNode temp = new ListNode();
//                 temp.val = q.val;
//                 q = q.next;
//                 finall.next = temp;
//                 finall = finall.next;
//             }
//         }

//         return result.next;
    }
}

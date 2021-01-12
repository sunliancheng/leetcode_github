package LC0_200.LC100_150;

import LeetCodeUtils.ListNode;
import org.junit.Test;

public class LC148_Sort_List {

//    public ListNode sortList(ListNode head) {
//        return sort(head);
//    }
//
//    public ListNode sort(ListNode head) {
//        if (head == null || head.next == null)
//            return null;
//        if (head.next.next == null) {
//            // length is equals to 2
//            if (head.val > head.next.val) {
//                int tem = head.val;
//                head.val = head.next.val;
//                head.next.val = tem;
//            }
//            return head;
//        }
//
//        ListNode mid = getMid(head);
//        ListNode next = mid.next;
//        mid.next = null;
//        ListNode left = sort(head);
//        ListNode right = sort(next);
//        return merge(left, right);
//    }
//
//    public ListNode getMid(ListNode head) {
//        ListNode slow = head, fast = head;
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }
//
//    public ListNode merge(ListNode h1, ListNode h2) {
//        ListNode head = new ListNode(), p = head;
//        while (h1 != null || h2 != null) {
//            if (h1 != null && h2 != null) {
//                if (h1.val < h2.val) {
//                    p.next = h1;
//                    h1 = h1.next;
//                    p = p.next;
//                } else {
//                    p.next = h2;
//                    h2 = h2.next;
//                    p = p.next;
//                }
//            } else if (h1 == null && h2 == null) {
//                break;
//            } else if (h1 == null) {
//                p.next = h2;
//                h2 = h2.next;
//                p = p.next;
//            } else {
//                p.next = h1;
//                h1 = h1.next;
//                p = p.next;
//            }
//        }
//        return head.next;
//    }


    public ListNode sortList(ListNode head) {
        if (head == null)
            return head;
        if (head.next == null)
            return head;
        if (head.next.next == null)
            return sort(head);

        ListNode mid = split(head);

        if (!isSmallerThan2(mid))
            mid = sortList(mid);
        if (!isSmallerThan2(head))
            head = sortList(head);

        sort(head);
        sort(mid);

        if (head.val < mid.val)
            return merge(head, mid);
        else
            return merge(mid, head);

    }

    /**
     * assume the length of the listnode is smaller than and equal to 2
     * @param head
     * @return
     */
    public ListNode sort(ListNode head) {
        if (head.next == null)
            return head;
        else {
            if (head.val < head.next.val)
                return head;
            else {
                int tem = head.val;
                head.val = head.next.val;
                head.next.val = tem;
            }
        }
        return head;
    }

    public ListNode split(ListNode start) {
        if (isSmallerThan2(start)) {
            return start;
        }
        ListNode p1 = start, p2 = start, p1_pre = start;
        while (p1 != null && p2 != null) {
            p1_pre = p1;
            p1 = p1.next;
            p2 = p2.next;
            if (p2 != null)
                p2 = p2.next;
        }
        p1_pre.next = null;
        return p1;
    }

    /**
     *  assume that h1.val always smaller than h2.val
     */
    public ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummyHead = new ListNode();
        ListNode newTail = dummyHead;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                newTail.next = h1;
                h1 = h1.next;
                newTail = newTail.next;
            } else {
                newTail.next = h2;
                h2 = h2.next;
                newTail = newTail.next;
            }
        }
        if (h1 == null) {
            newTail.next = h2;
        } else
            newTail.next = h1;
        return dummyHead.next;
    }

    public int count(ListNode head) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            count++;
        }
        return count;
    }

    public boolean isSmallerThan2(ListNode head) {
        ListNode p = head;
        if (p.next != null) {
            if (p.next.next == null)
                return true;
            return false;
        }
        return true;
    }


    @Test
    public void test() {
        ListNode.print(sortList(ListNode.createListNode("2,1")));
    }

    /**
     *  4 1 2 5 9 3
     *  1 2
     *  4
     */

}

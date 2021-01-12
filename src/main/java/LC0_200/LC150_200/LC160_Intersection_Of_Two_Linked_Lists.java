package LC0_200.LC150_200;

import LeetCodeUtils.ListNode;
import org.junit.Test;

import java.util.HashMap;

public class LC160_Intersection_Of_Two_Linked_Lists {

    @Test
    public void test() {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode result = null;
        ListNode p = headA;
        while (p != null) {
            map.put(p, p);
            p = p.next;
        }
        p = headB;
        while (p != null) {
            ListNode tem = map.getOrDefault(p, null);
            if (tem != null) {
                return tem;
            }
            p = p.next;
        }
        return result;
    }

}

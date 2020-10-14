package LeetCodeUtils;


public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void print(ListNode h) {
        while (h != null) {
            System.out.print(h.val + " ");
            h = h.next;
        }
        System.out.println();
    }

    /**
     * s should be like : "1,2,3,4"
     * @param s
     * @return
     */
    public static ListNode createListNode(String s) {
        String[] ss = s.split(",");
        ListNode root = new ListNode(), p = root;
        for (String str : ss) {
            ListNode tem = new ListNode(Integer.valueOf(str));
            p.next = tem;
            p = p.next;
        }
        return root.next;
    }

}
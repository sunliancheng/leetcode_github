package LC1600_1800.LC1600_1650;

import org.junit.Test;

public class LC1670_Design_Front_Middle_Back_Queue {

    @Test
    public void test() {
        FrontMiddleBackQueue fq = new FrontMiddleBackQueue();
        fq.popMiddle();
        fq.popMiddle();
        fq.pushMiddle(8);
        //fq.popFront();
        fq.popBack();
        fq.popFront();
        fq.popMiddle();
        System.out.println();
    }
}

class FrontMiddleBackQueue {

    int size = 0;
    Node head, tail, middle;

    public FrontMiddleBackQueue() {
        head = new Node(0);
        tail = head;
        middle = head;
    }

    public void pushFront(int val) {
        Node node = new Node(val, head.next, head);
        if (head.next != null)
            node.next.prev = node;
        head.next = node;
        size++;
        if (size == 1) {
            tail = node;
            middle = node;
        }
        if (size % 2 == 0) {
            middle = middle.prev;
        }
    }

    public void pushMiddle(int val) {
        if (size % 2 == 0) {
            // 偶数
            Node node = new Node(val, middle.next, middle);
            middle.next = node;
            Node next = node.next;
            if (next != null)
                next.prev = node;
            middle = middle.next;
            if (size == 0)
                tail = node;
        } else {
            // 奇数
            Node node = new Node(val, middle, middle.prev);
            Node prev = node.prev;
            prev.next = node;
            middle.prev = node;
            middle = middle.prev;
        }
        size++;
    }

    public void pushBack(int val) {
        Node node = new Node(val, tail.next, tail);
        tail.next = node;
        tail = tail.next;
        size++;
        if (size % 2 != 0) {
            middle = middle.next;
        }
    }

    public int popFront() {
        if (size <= 0) return -1;
        int val = -1;
        Node node = head.next;
        if (node != null) {
            head.next = node.next;
            if (head.next != null)
                head.next.prev = head;
            val = node.val;
        }
        node = null;
        if (size % 2 == 0) {
            middle = middle.next;
        }
        --size;
        if (size == 0) {
            tail = head;
            middle = head;
            tail.next = null;
            tail.prev = null;
            middle.prev = null;
            middle.next = null;
        }
        return val;
    }

    public int popMiddle() {
        if (size <= 0) return -1;
        int val = middle.val;
        if (middle.next != null)
            middle.next.prev = middle.prev;
        middle.prev.next = middle.next;

        if (size % 2 == 0) {
            middle = middle.next;
        } else {
            middle = middle.prev;
        }
        --size;
        if (size == 0) {
            tail = head;
            middle = head;
            tail.next = null;
            tail.prev = null;
            middle.prev = null;
            middle.next = null;
        }
        return val;
    }

    public int popBack() {
        if (size <= 0) return -1;
        Node node = tail;
        tail = tail.prev;
        if (tail != null)
            tail.next = null;
        int val = node.val;
        node = null;
        if (size % 2 != 0)
            middle = middle.prev;
        --size;
        if (size == 0) {
            tail = head;
            middle = head;
            tail.next = null;
            tail.prev = null;
            middle.prev = null;
            middle.next = null;
        }
        return val;
    }

    class Node {

        int val;
        Node next = null, prev = null;

        public Node (int val) { this.val = val; }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
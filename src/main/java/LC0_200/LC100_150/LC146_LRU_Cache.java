package LC0_200.LC100_150;

import java.util.HashMap;

public class LC146_LRU_Cache {

    class LRUCache {

        private class Dequeue {
            Dequeue next, prev;
            int value, key;
            public Dequeue (int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        Dequeue head = null, tail = null;
        HashMap<Integer, Dequeue> cache = null;
        int capacity = 0;

        public LRUCache(int capacity) {
            cache = new HashMap<Integer, Dequeue>();
            this.capacity = capacity;
            initializeDequeue();
        }

        public void initializeDequeue() {
            head = new Dequeue(-1, -1);
            tail = new Dequeue(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Dequeue node = cache.get(key);
            if (node == null)
                return -1;
            delete(node);
            insertAtLast(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Dequeue node = cache.get(key);
                node.value = value;
                node.key = key;
                delete(node);
                insertAtLast(node);
            } else {
                if (cache.size() == capacity) {
                    int keyToRemove = deleteLeastRecentlyUsed();
                    cache.remove(keyToRemove);
                }
                Dequeue node = new Dequeue(key, value);
                insertAtLast(node);
                cache.put(key, node);
            }
        }

        private void delete(Dequeue node) {
            Dequeue prev = node.prev;
            Dequeue next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private void insertAtLast(Dequeue node) {
            Dequeue prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
        }

        private int deleteLeastRecentlyUsed() {
            Dequeue node = head.next;
            head.next = node.next;
            node.next.prev = head;
            node.next = null;
            node.prev = null;
            return node.key;
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

}

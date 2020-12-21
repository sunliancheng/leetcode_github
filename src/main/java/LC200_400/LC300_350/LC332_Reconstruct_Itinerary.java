package LC200_400.LC300_350;

import org.junit.Test;
import sun.awt.image.ImageWatched;

import java.util.*;

public class LC332_Reconstruct_Itinerary {

    @Test
    public void test() {
        List<List<String>> tickets = new ArrayList<>();
        List<String> ls1 = new ArrayList<>(); ls1.add("1"); ls1.add("2");
        List<String> ls3 = new ArrayList<>(); ls3.add("1"); ls3.add("4");
        List<String> ls2 = new ArrayList<>(); ls2.add("2"); ls2.add("4");
        List<String> ls4 = new ArrayList<>(); ls4.add("2"); ls4.add("3");
        List<String> ls5 = new ArrayList<>(); ls5.add("3"); ls5.add("5");
        tickets.add(ls1); tickets.add(ls2); tickets.add(ls3); tickets.add(ls4); tickets.add(ls5);
        findItinerary(tickets);
    }

    LinkedList<String> res;
    public List<String> findItinerary(List<List<String>> tickets) {
        res = new LinkedList<>();
        // 最小字典顺序 可以使用 PriorityQueue
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ls : tickets) {
            PriorityQueue<String> pq = new PriorityQueue<>();
            if (!map.containsKey(ls.get(0)))
                map.put(ls.get(0), new PriorityQueue<>());
            map.get(ls.get(0)).offer(ls.get(1));
        }
        bfs(map, "1");
        return res;
    }

    void bfs(HashMap<String, PriorityQueue<String>> map, String start) {
        PriorityQueue<String> pq = map.get(start);
        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            bfs(map, next);
        }
        res.addFirst(start);
    }

}

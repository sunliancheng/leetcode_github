package LC400_600.LC500_550;

import org.junit.Test;

import java.util.*;

public class LC514_Freedom_Trail {

    @Test
    public void test() {
        System.out.println(findRotateSteps("dcba", "abcd"));
    }

    int result = Integer.MAX_VALUE;

    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            char c = ring.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c, list);
            }
        }
        int[][] memo = new int[n][26];

        dfs(0, key, 0, map, memo, n, key.length());

        return result;
    }

    public void dfs (int cur, String key, int level, Map<Character, List<Integer>> map, int[][] memo, int n, int tem) {
        if (level == key.length()) {
            result = result < tem ? result : tem;
            return;
        }
        char c = key.charAt(level);
        List<Integer> list = map.get(c);
        for (int i : list) {
            int anticlockwise = Math.abs(cur - i), clockwise = n - anticlockwise;
            dfs(getCur(n, cur + anticlockwise), key, 1 + level, map, memo, n, anticlockwise + tem);
            dfs(getCur(n, cur - clockwise), key, 1 + level, map, memo, n, clockwise + tem);
        }
    }

    public int getCur(int n, int cur) {
        cur = cur % (n - 1);
        if (cur < 0) cur += n;
        return cur;
    }


}

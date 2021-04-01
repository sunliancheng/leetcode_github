package LC400_600.LC500_550;

import org.junit.Test;

import java.util.*;

public class LC514_Freedom_Trail {

    @Test
    public void test() {

        //"xrrakuulnczywjs"
        //"jrlucwzakzussrlckyjjsuwkuarnaluxnyzcnrxxwruyr"
        String ring = "godding";
        String key = "gd";
        System.out.println(findRotateSteps(ring, key));
    }

    public int findRotateSteps(String ring, String key) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ring.length(); ++i) {
            char c = ring.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c, list);
            }
        }
        int[][] memo = new int[ring.length()][key.length()];
        return dfs(0, key, 0, map, memo, ring.length());
    }

    public int dfs (int cur, String key, int level, Map<Character, List<Integer>> map, int[][] memo, int n) {
        if (level == key.length()) { return 0; }
        char c = key.charAt(level);
        if (memo[cur][level] != 0) return memo[cur][level];
        List<Integer> list = map.get(c); int min = Integer.MAX_VALUE;
        for (int i : list) {
            int anticlockwise = getAnticlockwise(cur, i, n), clockwise = getClockwise(cur, i, n);
            int r1 = anticlockwise + dfs(i, key, 1 + level, map, memo, n);
            int r2 = clockwise + dfs(i, key, 1 + level, map, memo, n);
            min = Math.min(Math.min(r1, r2), min);
        }
        memo[cur][level] = 1 + min;
        return memo[cur][level];
    }

    public int getAnticlockwise(int cur, int target, int n) {
        int offSet = target - cur;
        if (offSet < 0) offSet = n + offSet;
        return offSet;
    }

    public int getClockwise(int cur, int target, int n) {
        int offSet = cur - target;
        if (offSet < 0) offSet = n + offSet;
        return offSet;
    }


}

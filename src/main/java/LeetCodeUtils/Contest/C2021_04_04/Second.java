package LeetCodeUtils.Contest.C2021_04_04;

import org.junit.Test;

import java.util.HashMap;
import java.util.*;

public class Second {

    @Test
    public void test() {

    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            if (!map.containsKey(log[0])) {
                Set<Integer> set = new HashSet<>();
                set.add(log[1]);
                map.put(log[0], set);
            } else {
                Set<Integer> set = map.get(log[0]);
                set.add(log[1]);
            }
        }
        int[] result = new int[k];
        for (int i : map.keySet()) {
            int size = map.get(i).size();
            result[size - 1]++;
        }
        return result;
    }

}

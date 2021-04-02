package LC1600_1800.LC1700_1750;

import org.junit.Test;

import java.util.*;

public class LC1722_Minimize_Hamming_Distance_After_Swap_Operations {

    @Test
    public void test() {
        int[] source = new int[]{2,3,1};
        int[] target = new int[]{1,2,2};
        int[][] allowedSwaps = new int[][]{{0,2}, {1,2}};
        System.out.println(minimumHammingDistance(source, target, allowedSwaps));
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] swaps) {
        int length = source.length, minDistance = 0;
        int[] parent = new int[length];
        Arrays.fill(parent, -1);

        for(int i = 0; i < swaps.length; i++) {
            int x = find(parent, swaps[i][0]);
            int y = find(parent, swaps[i][1]);
            if(x != y) union(parent, x, y);
        }

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < length; i++) {
            int val = source[i];
            int root = find(parent, i);
            map.putIfAbsent(root, new HashMap<>());
            HashMap<Integer, Integer> count = map.get(root);
            count.put(val, count.getOrDefault(val, 0)+1);
        }

        for(int i = 0; i < length; i++) {
            int val = target[i];
            int root = find(parent, i);
            HashMap<Integer, Integer> count = map.get(root);
            if(count.getOrDefault(val, 0) == 0)
                minDistance++;
            else count.put(val, count.getOrDefault(val,0)-1);
        }

        return minDistance;
    }

    private int find(int[] parent, int key) {
        if(parent[key] == -1) return key;
        return find(parent, parent[key]);
    }

    private void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[ySet] = xSet;
    }

}

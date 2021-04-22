package LeetCodeUtils.Contest.C2021_04_19;

import java.util.*;

public class Forth {

    public int getXORSum(int[] arr1, int[] arr2) {
        int re = -1;
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; ++i) {
            for (int j = 0; j < arr2.length; ++j) {
                int val = 0;
                if (map.containsKey(new int[]{arr1[i],arr2[j]})) {
                    val = map.get(new int[]{arr1[i],arr2[j]});
                } else {
                    val = arr1[i] & arr2[j];
                    map.put(new int[]{arr1[i],arr2[j]}, val);
                }
                //int tem = map.getOrDefault(new int[]{arr1[i],arr2[j]}, arr1[i] & arr2[j]);
                if (i == 0 && j == 0) {
                    re = val;
                }
                else re ^= val;
            }
        }
        return re;
    }

}

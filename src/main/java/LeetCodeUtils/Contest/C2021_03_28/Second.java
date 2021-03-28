package LeetCodeUtils.Contest.C2021_03_28;

import org.junit.Test;

import java.util.Arrays;

public class Second {

    @Test
    public void test() {
        System.out.println(reinitializePermutation(8));
    }

    int result = Integer.MAX_VALUE;

    public int reinitializePermutation(int n) {
        int[] arr = new int[n], perm = new int[n];
        for(int i = 0; i < n; ++i)
            perm[i] = i;

        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) arr[i] = perm[i / 2];
            else arr[i] = perm[n / 2 + (i - 1) / 2];
        }

        dfs(arr, perm, 0, 0);
        return result;
    }

    public boolean checkEqual(int[] arr, int[] perm) {
        if (arr.length != perm.length) return false;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != perm[i]) return false;
        }
        return true;
    }

    public void dfs(int[] arr, int[] perm, int t, int level) {
        if (checkEqual(arr, perm)) {
            result = result < t ? result : t;
            return;
        }
        if (level == arr.length) return;
        int[] temp = Arrays.copyOf(arr, arr.length);
        for (int i = level; i < arr.length; ++i) {
            exchane(arr, level, i);
            dfs(arr, perm, 1 + t, level + 1);
            arr = Arrays.copyOf(temp, arr.length);
        }
    }

    public void exchane(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }


}

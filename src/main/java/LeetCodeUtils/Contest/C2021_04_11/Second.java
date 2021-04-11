package LeetCodeUtils.Contest.C2021_04_11;

import org.junit.Test;

public class Second {

    @Test
    public void test() {
        System.out.println(findTheWinner(5, 2));
    }

    int count = 0;
    public int findTheWinner(int n, int k) {
        count = n;
        boolean[] arr = new boolean[n + 1];
        int idx = 1;
        while (count > 1) {
            int next = findNext(arr, idx, k);
            idx = next;
            arr[next] = true;
            count--;
        }
        for (int i = 1; i < arr.length; ++i)
            if (!arr[i]) return i;
        return 0;
    }

    public int findNext(boolean[] arr, int idx, int remain) {
        if (idx > arr.length - 1) idx -= arr.length - 1;
        if (idx == 0) idx = 1;
        if (remain == 1 && !arr[idx]) return idx;
        else if (remain == 1) return findNext(arr, 1 + idx, remain);
        if (!arr[idx]) return findNext(arr, idx + 1, remain - 1);
        else return findNext(arr, idx + 1, remain);
    }

}

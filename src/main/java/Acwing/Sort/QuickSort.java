package Acwing.Sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {

    public void quick_sort_Template(int[] q, int l, int r) {
        if (l >= r) return;

        int x = q[l], i = l - 1, j = r + 1;

        while (i < j) {
            do i++; while (q[i] < x);
            do j--; while (q[j] > x);
            if (i < j) {
                int tem = q[i];
                q[i] = q[j];
                q[j] = tem;
            }
        }

        quick_sort(q, l, j);  // 这里必须用j，如果用 i，需要替换成 quick_sort(q, l, i - 1) quick_sort(q, i, r) 再遇到[1,2]的时候会出现死循环
        quick_sort(q, j + 1, r);
    }

    @Test
    public void test() {
        int[] arr = new int[]{1, 2};
        quick_sort(arr, 0, 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public void quick_sort(int[] q, int l, int r) {

        if (l >= r) return;
        int x = q[l], i = l - 1, j = r + 1;

        while (i < j) {
            do i++; while (q[i] < x);
            do j--; while (q[j] > x);
            if (i < j) {
                int tem = q[i];
                q[i] = q[j];
                q[j] = tem;
            }
        }
        quick_sort(q, l, j);
        quick_sort(q, j + 1, r);
    }


}

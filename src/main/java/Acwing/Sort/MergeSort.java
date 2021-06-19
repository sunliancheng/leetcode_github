package Acwing.Sort;

import org.junit.Test;

import java.util.Arrays;

public class MergeSort {

    /*
    1. 确定分界点 mid = l + r >> 1;
    2. 归并排序 left right
    3. 合二为一
     */

    public void merge_sort_Template(int[] q, int l, int r) {
        int[] tem = new int[q.length];
        if (l >= r) return;
        int mid = l + r >> 1;
        merge_sort_Template(q, l, mid);
        merge_sort_Template(q, mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r)
            if (q[i] <= q[j]) tem[k++] = q[i++];
            else tem[k++] = q[j++];
        while (i <= mid) tem[k++] = q[i++];
        while (j <= r) tem[k++] = q[j++];

        for (i = l, j = 0; i <= r; i++, j++) q[i] = tem[j];
    }

    @Test
    public void test() {
        int[] arr = new int[] {3,2,8,6,1};
        merge_sort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public void merge_sort(int[] q, int l, int r) {
        if (l >= r) return;
        int[] tem = new int[q.length];
        int mid = l + r >> 1;

        merge_sort(q, l, mid);
        merge_sort(q, mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] < q[j]) tem[k++] = q[i++];
            else tem[k++] = q[j ++];
        }
        while (i <= mid) tem[k++] = q[i++];
        while (j <= r) tem[k++] = q[j++];

        for (i = l, k = 0; i <= r; ++i) q[i] = tem[k++];
    }
}

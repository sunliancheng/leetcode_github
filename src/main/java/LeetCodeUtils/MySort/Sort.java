package LeetCodeUtils.MySort;

public class Sort {

    // left is included and the right is not included
    public static void quickSort(int[] nums, int l, int r) {
        if (l + 1 >= r) return;
        int first = l, last = r - 1, key = nums[first];
        while (first < last) {
            while (first < last && nums[last] >= key)
                --last;
            nums[first] = nums[last];
            while (first < last && nums[first] <= key)
                ++first;
            nums[last] = nums[first];
        }
        nums[first] = key;
        quickSort(nums, l, first);
        quickSort(nums, first + 1, r);
    }

    public static void mergeSort(int[] nums, int l, int r, int[] temp) {
        if (l >= r - 1) return;
        int m = (r + l) / 2;
        // divide
        mergeSort(nums, l, m, temp);
        mergeSort(nums, m, r, temp);
        // conquer
        int p = 1, q = m, i = 1;
        while (p < m || q < r)
            if (q >= r || (p < m && nums[p] <= nums[q]))
                temp[i++] = nums[p++];
            else
                temp[i++] = nums[q++];
        for (i = l; i < r; ++i)
            nums[i] = temp[i];

    }

    public static void insertionSort(int[] nums, int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; --j) {
                nums[j] ^= nums[j - 1];
                nums[j - 1] ^= nums[j];
                nums[j] ^= nums[j - 1];
            }

        }
    }

    public static void bubbleSort(int[] nums, int n) {
        boolean swapped = false;
        for (int i = 1; i < n; ++i) {
            swapped = false;
            for (int j = 1; j < n - i; ++j) {

            }
        }
    }




}

package LC1800_2000.LC1800_1850;

import java.util.Arrays;

public class LC1818_Minimum_Absolute_Sum_Difference {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] diff = new int[nums1.length];
        int tem = 0, max = 0;
        for (int i = 0; i < nums1.length; ++i) {
            int val = nums1[i] - nums2[i];
            diff[i] = val < 0 ? -val : val;
            tem += diff[i];
            tem %= (1e9 + 7);
        }
        Arrays.sort(nums1);
        for (int i = 0; i < nums1.length; ++i) {
            int val = nums1[find(nums1, nums2[i], 0, nums1.length - 1)] - nums2[i];
            val = val < 0 ? -val : val; val = diff[i] - val;
            max = max > val ? max : val;
        }
        return (int) ((tem - max) % (1e9 + 7));
    }

    public int find(int[] arr, int target, int l, int r) {
        if (l == r) return l;
        if (r - l == 1) {
            if (arr[r] - target < target - arr[l]) return r;
            else return l;
        }
        int mid = (l + r) / 2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) return find(arr, target, l, mid);
        else return find(arr, target, mid, r);
    }

}

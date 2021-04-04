package LeetCodeUtils.Contest.C2021_04_04;

import LeetCodeUtils.MyPrint;
import org.junit.Test;

import java.util.Arrays;
import java.util.*;
import java.util.PriorityQueue;

public class Third {

    @Test
    public void test() {
        //System.out.println(find(new int[]{1,2,3,4,5,7}, 5, 0, 5));
        System.out.println(minAbsoluteSumDiff(new int[]{1,10,4,4,2,7}, new int[]{9,3,5,1,7,4}));
    }


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

package LC0_200.LC50_100;

public class LC88_Merge_Sorted_Array {





    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = nums1.length - nums2.length - 1, p2 = nums2.length - 1, p = nums1.length - 1;

        while (p >= 0 && p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else
                nums1[p--] = nums2[p2--];
        }
    }

}

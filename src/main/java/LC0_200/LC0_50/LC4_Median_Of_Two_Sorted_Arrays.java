package LC0_200.LC0_50;

public class LC4_Median_Of_Two_Sorted_Arrays {

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n) {  // make m <= n
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            m = nums1.length; n = nums2.length;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while(iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if(i < iMax && nums2[j - 1] > nums1[i])
                iMin = i + 1; // i is too small
            else if(i > iMin && nums1[i - 1] > nums2[j])
                iMax = i - 1; // i is too big
            else {  // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums2[j-1]; }
                else if (j == 0) { maxLeft = nums1[i-1]; }
                else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = nums2[j]; }
                else if (j == n) { minRight = nums1[i]; }
                else { minRight = Math.min(nums2[j], nums1[i]); }

                return (maxLeft + minRight) / 2.0;

            }
        }

        return 0.0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        /**
         *
         * 讨论三种情况，奇偶，奇奇，偶偶
         */

        /**
         * 奇偶
         * 奇数列的第 i 个下标，表示 nums[i] 前有 i 个数；第 i 个数有意义
         * 偶数列的对应下标 j = （lenA + lenB - 1) / 2, 表示前面有 j 个数，并且 第 j 个数没有意义
         * 对应 candidate 是 nums[i]
         */


        /**
         * 偶偶
         * 偶数列第第 i 个下标，表示 前面有 i 个数，并且第 i 个数没有意义
         * 另一个偶数列对应下标 j = (lenA + lenB) / 2, 表示前面有 j 个数，并且 第 j 个数没有意义
         * 对应candidate 是
         * (max(nums1[i - 1], nums2[j - 1]) + min(nums1[i + 1, nums2[j + 1]) /2
         */

        /**
         * 奇奇
         * 奇数列第 i 个下标，表示 表示 nums[i] 前有 i 个数；第 i 个数有意义
         * 另一个奇数列对应下标 j = (lenA + lenB) / 2 - 1, 表示前面有 j 个数，并且第 j 个数有意义
         * candidate : (nums[i] + nums[j]) / 2
         */

        int len1 = nums1.length, len2 = nums2.length;
        if ((len1 + len2) % 2 == 0) {

        } else {
            // 奇偶 假设数组1 是 奇
            if (len1 % 2 == 0) {
                int[] tem = nums1;
                nums1 = nums2;
                nums2 = tem;
            }


        }

        return 0.0;


    }
}

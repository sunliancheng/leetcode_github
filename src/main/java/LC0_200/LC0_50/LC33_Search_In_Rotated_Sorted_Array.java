package LC0_200.LC0_50;

public class LC33_Search_In_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {

        for (int i = 0; i < nums.length; ++i)
            if (nums[i] == target)
                return i;
        return -1;

    }

}

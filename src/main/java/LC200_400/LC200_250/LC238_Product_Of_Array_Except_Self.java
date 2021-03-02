package LC200_400.LC200_250;

public class LC238_Product_Of_Array_Except_Self {

    public int[] productExceptSelf(int[] nums) {
        int product = 1, count_zero = 0;
        for (int i : nums) {
            if (i != 0) product *= i;
            else count_zero++;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                if (count_zero != 0) nums[i] = 0;
                else nums[i] = product / nums[i];
            } else if (count_zero == 1)
                nums[i] = product;
            else
                nums[i] = 0;
        }
        return nums;
    }

}

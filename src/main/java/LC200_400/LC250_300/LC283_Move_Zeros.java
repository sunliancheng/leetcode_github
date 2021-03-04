package LC200_400.LC250_300;

public class LC283_Move_Zeros {

    public void moveZeroes(int[] nums) {

        int move_step = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                move_step++;
            } else {
                int offSet = i - move_step;
                nums[offSet] = nums[i];
            }
        }

        for (int i = nums.length - 1; i >= nums.length - move_step; --i)
            nums[i] = 0;
    }

}

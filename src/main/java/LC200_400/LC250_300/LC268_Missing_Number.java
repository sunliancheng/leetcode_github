package LC200_400.LC250_300;

public class LC268_Missing_Number {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; ++i)
            sum += (i - nums[i]);


        return (sum + nums.length);
    }
}

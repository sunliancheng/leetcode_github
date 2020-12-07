package LC0_200.LC100_150;

public class LC136_Single_Number {
    public int singleNumber(int[] nums) {
        int n = 0;
        for(int i : nums){
            n ^= i;
        }
        return n;
    }
}

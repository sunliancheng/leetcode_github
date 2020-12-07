package LC0_200.LC150_200;

public class LC169_Majority_Element {
    public int majorityElement(int[] nums) {
        if(nums.length == 0) return 0;
        int candidate = 0;
        int count = 0;

        for(int i : nums){
            if(count == 0) candidate = i;
            if(i == candidate) count++;
            else count--;
        }
        return candidate;
    }
}

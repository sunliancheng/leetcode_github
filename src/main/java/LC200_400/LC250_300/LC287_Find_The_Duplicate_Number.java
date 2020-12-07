package LC200_400.LC250_300;

public class LC287_Find_The_Duplicate_Number {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        fast = nums[0];

        while(fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}

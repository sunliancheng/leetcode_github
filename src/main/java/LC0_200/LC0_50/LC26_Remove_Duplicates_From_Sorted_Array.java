package LC0_200.LC0_50;

public class LC26_Remove_Duplicates_From_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int count = 1;
        int cur = 0;
        int i = 0;
        while(i < nums.length){
            if(nums[cur] != nums[i]){
                count++;
                nums[++cur] = nums[i];
            }
            ++i;
        }
        return count;
    }
}

package LC0_200.LC0_50;

public class LC27_Remove_Element {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int count = 0;
        int cur = 0;
        int i = 0;
        while(i < nums.length){
            if(nums[i] != val){
                count++;
                nums[cur++] = nums[i];
            }
            ++i;
        }
        return count;

    }
}

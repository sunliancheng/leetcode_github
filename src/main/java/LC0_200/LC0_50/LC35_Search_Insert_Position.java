package LC0_200.LC0_50;

public class LC35_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; ++i){

            if(i == nums.length - 1){
                if(target > nums[i]){
                    return ++i;
                } else if(target <= nums[i]) return i;
            }else{
                if(target > nums[i] && target <= nums[i + 1]){
                    return ++i;
                } else if(target <= nums[i]) return i;
            }

        }
        return -1;
    }
}

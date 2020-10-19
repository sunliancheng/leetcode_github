package LC0_200.LC0_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18_4_Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int target_temp;

        for(int i = 0; i < nums.length - 3; i++){

            if(i != 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < nums.length - 2; j++){

                if(j != i + 1 && nums[j] == nums[j - 1]) continue;

                int lowPtr = j + 1; int highPtr = nums.length - 1;
                target_temp = target - (nums[i] + nums[j]);

                while(lowPtr < highPtr){

                    if(lowPtr != j + 1 && nums[lowPtr] == nums[lowPtr - 1]) {++lowPtr; continue;}
                    if(highPtr != nums.length - 1 && nums[highPtr] == nums[highPtr + 1]) {--highPtr; continue;}

                    if(nums[lowPtr] + nums[highPtr] == target_temp){
                        result.add(Arrays.asList(nums[i], nums[j], nums[lowPtr], nums[highPtr]));
                        ++lowPtr;
                        --highPtr;
                    }else if(nums[lowPtr] + nums[highPtr] < target_temp) ++lowPtr;
                    else --highPtr;

                }

            }

        }
        return result;
    }
}

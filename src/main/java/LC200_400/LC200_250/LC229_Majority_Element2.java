package LC200_400.LC200_250;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *  What a shame, I forget how to solve the problems after 5 months
 *  2020-09-22 11:08 PM at Hangzhou
 */

public class LC229_Majority_Element2 {

    /**
     * Description:
     * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     *
     * Note: The algorithm should run in linear time and in O(1) space.
     *
     * Example 1:
     *
     * Input: [3,2,3]
     * Output: [3]
     * Example 2:
     *
     * Input: [1,1,1,3,3,2,2,2]
     * Output: [1,2]
     */

    /**
     * since the number of majority numbers is 2
     * if there are 3 majority numbers, there sum will larger than n!
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = Integer.MAX_VALUE, candidate2 = Integer.MAX_VALUE, count1 = 0, count2 = 0;

        for(int n : nums){

            if(count1 == 0 && n != candidate2)
                candidate1 = n;

            //candidate2 may be MAX_VALUE after several loops
            if(count2 == 0 && n != candidate1)
                candidate2 = n;

            if(n == candidate1)
                count1++;
            else if(n == candidate2)
                count2++;
            else{
                count1--;
                count2--;
            }

        }
        List<Integer> result = new ArrayList<>();

        count1=count2=0;
        for(int n : nums){
            if(n == candidate1)
                count1++;
            if(n == candidate2)
                count2++;
        }

        if(count1 > nums.length/3)
            result.add(candidate1);
        if(count2 > nums.length/3 && candidate1 != candidate2)
            result.add(candidate2);

        return result;
    }

    @Test
    public void test() {
        System.out.println(majorityElement(new int[]{3, 3, 4}));;
    }

}

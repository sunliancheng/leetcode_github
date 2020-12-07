package LC400_600.LC500_550;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

public class LC540_Single_Element_In_A_Sorted_Array {

    @Test
    public void test() {
        //System.out.println(singleNonDuplicate(MyMatrix.
               // OneDIntMatrixAdapter("[1,1,2,3,3,4,4,8,8]")));
        System.out.println(singleNonDuplicate(MyMatrix.
                OneDIntMatrixAdapter("[1]")));
    }


    public int singleNonDuplicate(int[] nums) {
        int s = 0, e = nums.length - 1;

        while (s <= e) {
            if (s == e)
                return nums[s];
            int mid = (s + e) / 2;
            if (mid % 2 == 0) {
                // compare with the right side
                if (nums[mid] == nums[mid + 1]) {
                    s = mid + 2;
                } else {
                    if (nums[mid] == nums[mid - 1]) {
                        e = mid - 2;
                    } else {
                        return nums[mid];
                    }
                }
            } else {
                //compare with the left sie
                if (nums[mid] == nums[mid - 1]) {
                    s = mid + 1;
                } else {
                    if (nums[mid] == nums[mid + 1]) {
                        e = mid - 1;
                    } else {
                        return nums[mid];
                    }
                }
            }

        }
        return nums[s];
    }

}

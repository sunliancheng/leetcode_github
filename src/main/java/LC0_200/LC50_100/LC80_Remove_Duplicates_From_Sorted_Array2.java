package LC0_200.LC50_100;

import LeetCodeUtils.MyMatrix;
import LeetCodeUtils.MyPrint;
import org.junit.Test;

public class LC80_Remove_Duplicates_From_Sorted_Array2 {

    @Test
    public void test() {
        System.out.println(removeDuplicates(MyMatrix.OneDIntMatrixAdapter("[0,0,1,1,1,1,2,3,3]")));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int cur = 0, tem_count = 0, tem = nums[0];

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != tem) {
                tem = nums[i];
                tem_count = 1;
                nums[cur] = nums[i];
                cur++;
            } else {
                tem_count++;
                if (tem_count <= 2) {
                    nums[cur] = nums[i];
                    cur++;
                }
            }
        }
        return cur;
    }

}

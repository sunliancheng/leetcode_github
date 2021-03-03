package LC0_200.LC150_200;

import org.junit.Test;

public class LC189_Rotate_Array {

    @Test
    public void test() {
        rotate(new int[]{-1,-100,3,99}, 2);
    }

    public void rotate(int[] nums, int k) {
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int cur = start, prev = nums[start];
            do {
                int next = (cur + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                cur = next;
                count++;
            } while (start != cur);
        }
    }

}

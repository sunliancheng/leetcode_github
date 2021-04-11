package LeetCodeUtils.Contest.C2021_04_11;

import org.junit.Test;

public class First {

    @Test
    public void test() {

    }

    public int arraySign(int[] nums) {
        int countNegativeNum = 0;
        for (int i : nums) {
            if (i == 0) return 0;
            if (i < 0) {
                if (countNegativeNum == 0) countNegativeNum = 1;
                else countNegativeNum = 0;
            }
        }
        return countNegativeNum == 0 ? 1 : -1;
    }

    public int signFunc(int product) {
        if (product > 0) return 1;
        if (product == 0) return 0;
        else return -1;
    }
}

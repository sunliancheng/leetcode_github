package LC200_400.LC350_400;

import java.util.Random;

public class LC384_Suffle_An_Array {
}


class Solution {

    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int tem = array[i];
        array[i] = array[j];
        array[j] = tem;
    }

    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < array.length; ++i) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }
}
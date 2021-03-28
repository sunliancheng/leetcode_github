package LC1800_2000.LC1800_1850;

import LeetCodeUtils.MyPrint;
import org.junit.Test;

import java.util.Arrays;

public class LC1806_Minimum_Numbers_Of_Operations_To_Reinitialize_A_Permutation {

    @Test
    public void test() {
        System.out.println(reinitializePermutation(10));
    }

    public int reinitializePermutation(int n) {
        int[] ori = new int[n], perm = new int[n];
        for(int i = 0; i < n; ++i) {
            perm[i] = i;
            ori[i] = i;
        }

        int result = 0;
        while (true) {
            ++result;
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                if (i % 2 == 0) arr[i] = perm[i / 2];
                else arr[i] = perm[n / 2 + (i - 1) / 2];
            }
            perm = arr;
            if (equ(perm, ori)) break;
        }
        return result;
    }

    public boolean equ(int[] arr, int[] perm) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] != perm[i]) return false;
        }
        return true;
    }


}

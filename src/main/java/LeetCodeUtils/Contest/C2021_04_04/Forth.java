package LeetCodeUtils.Contest.C2021_04_04;

import org.junit.Test;
import sun.tools.jconsole.inspector.IconManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.*;

public class Forth {

    @Test
    public void test() {
        System.out.println(countDifferentSubsequenceGCDs(new int[]{6,10,3}));

        ArrayList<Integer> list = new ArrayList();
        list.add(6); list.add(3);
        System.out.println(findCommon(list));
    }

    public int countDifferentSubsequenceGCDs(int[] nums) {
        boolean[] visited = new boolean[200005];
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            visited[n] = true;
            max = Math.max(max, n);
        }
        int count = 0;
        for (int i = 1; i <= max; ++i) {
            int commonGCD = -1;
            for (int j = i; j <= max; j += i) {
                if (visited[j]) {
                    if (commonGCD == -1) commonGCD = j;
                    else commonGCD = gcd(commonGCD, j);
                }
            }
            if (i == commonGCD) count++;
        }
        return count;

    }

    private int gcd(int x, int y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }


}

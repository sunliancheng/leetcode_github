package LC200_400.LC200_250;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * created on 02/26/2021 in Hangzhou
 */

public class LC202_Happy_Number {

    @Test
    public void test() {
        System.out.println(isHappy(20));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            n = calculate(n);
        }
        return set.contains(1);
    }

    public int calculate(int n) {
        int result = 0;
        while (n >= 10) {
            int tem = n % 10;
            result += tem * tem;
            n = n / 10;
        }
        return result + n * n;
    }

}

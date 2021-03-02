package LC200_400.LC200_250;

import org.junit.Test;

/**
 * 2021/03/02 It is a not intuitive solution, and I quit. -_-
 */
public class LC233_Number_Of_Digit_One {

    @Test
    public void test() {
        countDigitOne(16);
    }

    public int countDigitOne(int n) {
        int memory = 0, residue = 0, base = 1, count = 0;
        while(n > 0) {
            int t = n % 10;
            if(t > 1) count += t * memory + base;
            else if(t == 1) count += memory + residue + 1;
            residue += t * base;
            n /= 10;
            memory = 10 * memory + base;
            base *= 10;
        }
        return count;
    }

}

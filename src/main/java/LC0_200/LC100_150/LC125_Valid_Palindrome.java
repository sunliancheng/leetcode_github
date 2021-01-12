package LC0_200.LC100_150;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC125_Valid_Palindrome {

    @Test
    public void test() {
        System.out.println('p' - 'P');
        System.out.println(isPalindrome("0P"));
    }
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            while (l < r) {
                Character c = s.charAt(l);
                if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
                    break;
                }
                ++l;
            }
            while (l < r) {
                Character c = s.charAt(r);
                if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
                    break;
                }
                --r;
            }
            if (s.charAt(l) == s.charAt(r) || isNotSame(s.charAt(l), s.charAt(r)) &&  Math.abs(s.charAt(l) - s.charAt(r)) == Math.abs('a' - 'A')) {
                ++l; --r;
            } else {
                return false;
            }

        }
        return true;
    }

    private boolean isNotSame(char c1, char c2) {
        if (c1 >= '0' && c1 <= '9') {
            if (c2 >= '0' && c2 <= '9')
                return true;
            else
                return false;
        } else {
            if (c2 >= '0' && c2 <= '9')
                return false;
            else
                return true;
        }
    }
}

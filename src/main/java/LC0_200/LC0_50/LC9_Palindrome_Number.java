package LC0_200.LC0_50;

public class LC9_Palindrome_Number {

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int low = 0, high = s.length() - 1;
        while (true) {
            if (low >= high) {
                return true;
            }

            if (s.charAt(low) != s.charAt(high)) {
                return false;
            } else {
                low++;
                high--;
            }
        }
    }

}

package LC600_800.LC650_700;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;

public class LC680_Valid_Palindrome2 {

    @Test
    public void test() {
        System.out.println(validPalindrome("hvxvuiewcjxqrfjmrxcnsaaazjnpvwcufatumlhadmahhbfahoohafbhhamdahlmutafucwvpnjzaaasncxrmjfrqxjcweiuvxvh"));
    }


    public boolean validPalindrome(String s) {
        return valid(s, true, 0, s.length() - 1);
    }

    public boolean valid(String s, boolean first, int l, int r) {
        while (l < r)
            if (s.charAt(l) == s.charAt(r))
                return valid(s, first, ++l, --r);
            else
                if (first) {
                    return valid(s, false, ++l, r) || valid(s, false, --l, --r);
                } else
                    return false;
        return  true;
    }


    /**
     * Given a non-empty string s,
     * you may delete at most one character.
     * Judge whether you can make it a palindrome.
     *
     * Example 1:
     *
     * Input: "aba"
     * Output: True
     */
}

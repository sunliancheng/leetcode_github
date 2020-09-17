package LC0_200.LC50_100;

import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

/**
 *  Runtime: 1ms   faster than 99.64%
 *  Memory Usage: 38.3 MB   less than 96.64%
 *  Sep 17 12:53 PM in Hangzhou
 */

public class LC93_Restore_IP_Addresses {

    private List<String> result = new ArrayList<String>();
    private StringBuilder sb = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        backTrace(s, 1);
        return result;
    }

    /**
     *
     *  @param hasUsed   in the current part of IP segment, how many Characters has been used
     *  @param s   the IP string
     *  @param index   there are 4 parts of IP segments, index represents which part is currently used
     */
    public void backTrace(String s, int index) {

        if (index == 4 && s.length() <= 3 && s.length() >= 1 && checkIfVaild(s)) {
            sb.append(s);
            result.add(sb.toString());
            sb.delete(sb.length() - s.length(), sb.length());
            return;
        } else if (index == 4)
            return;

        // 取一位
        if (s.length() >= 1 && checkIfVaild(s.substring(0, 1)) && s.length() - 1 <= (4 - index) * 3 && s.length() - 1 >= (4 - index)) {
            sb.append(s.charAt(0));
            sb.append('.');
            backTrace(s.substring(1), index + 1);
            sb.delete(sb.length() - 2, sb.length());
        }

        // 取二位
        if (s.length() >= 2 && checkIfVaild(s.substring(0, 2)) && s.length() - 2 <= (4 - index) * 3 && s.length() - 1 >= (4 - index)) {
            sb.append(s.substring(0, 2));
            sb.append('.');
            backTrace(s.substring(2), index + 1);
            sb.delete(sb.length() - 3, sb.length());
        }

        // 取三位
        if (s.length() >= 3 && checkIfVaild(s.substring(0, 3)) && s.length() - 3 <= (4 - index) * 3 && s.length() - 1 >= (4 - index)) {
            sb.append(s.substring(0, 3));
            sb.append('.');
            backTrace(s.substring(3), index + 1);
            sb.delete(sb.length() - 4, sb.length());
        }
    }

    private boolean checkIfVaild(String s) {
        if (s.startsWith("0") && s.length() > 1)
            return false;

        int result = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                result = result * 10 + s.charAt(i) - '0';
            } else
                return false;
        }
        if (result >=0 && result <= 255)
            return true;
        return false;
    }

    @Test
    public void test() {
        restoreIpAddresses("0000");
    }

}

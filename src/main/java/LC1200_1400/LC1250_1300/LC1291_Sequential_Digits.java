package LC1200_1400.LC1250_1300;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *  2020-09-20 1:35 AM at Hangzhou
 */
public class LC1291_Sequential_Digits {

    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> result = new ArrayList<>();
        String s = "123456789";
        int left = 0, right = left, flag = -1;
        while (left < s.length() && right < s.length()) {
            Integer temp = Integer.valueOf(s.substring(left, right + 1));
            String ss = s.substring(right, right + 1);
            if (temp < high && temp < Integer.valueOf(s.substring(left, s.length()))) {
                if (temp >= low)
                    result.add(temp);
                right++;
            } else if (temp <= high && s.substring(right, right + 1).equals("9") && temp <= Integer.valueOf(s.substring(left, s.length()))) {
                if (temp >= low)
                    result.add(temp);
                left++;
                right = left + 1;
            } else {
                left++;
                right = left + 1;
            }
        }
        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : ((o1 == o2) ? 0 : -1);
            }
        });
        return result;
    }

    @Test
    public void test() {
        sequentialDigits(1000, 13000);
    }

}

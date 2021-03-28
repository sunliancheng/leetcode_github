package LeetCodeUtils.Contest.C2021_03_28;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Demo {


    @Test
    public void test() {
        System.out.println(numDifferentIntegers("a123bc34d8ef34"));
    }

    public int numDifferentIntegers(String word) {
        boolean isNum = false;
        int prevIdx = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) >= '0' && word.charAt(i) <= '9') {
                if (isNum) continue;
                else {
                    isNum = true;
                    prevIdx = i;
                }
            } else {
                if (isNum) {
                    String n = word.substring(prevIdx, i);
                    n = deleteZero(n);
                    set.add(n);
                }
                isNum = false;
            }
        }
        if (isNum && word.charAt(word.length() - 1) >= '0' && word.charAt(word.length() - 1) <= '9') {
            String n = word.substring(prevIdx, word.length());
            n = deleteZero(n);
            set.add(n);
        }
        return set.size();
    }

    public String deleteZero(String s) {
        boolean flag = s.charAt(0) == '0';
        for (int i = 0; i < s.length(); ++i) {
            if (flag && s.charAt(i) == '0') continue;
            else {
                s = s.substring(i);
                return s;
            }
        }
        return s;
    }




}

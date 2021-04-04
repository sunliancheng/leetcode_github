package LeetCodeUtils.Contest.C2021_04_04;

import org.junit.Test;

public class First {

    @Test
    public void test() {

    }


    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");
        for (int i = 0; i < k; ++i) {
            sb.append(ss[i]);
            if (i != k - 1) sb.append(" ");
        }
        return sb.toString();
    }



}

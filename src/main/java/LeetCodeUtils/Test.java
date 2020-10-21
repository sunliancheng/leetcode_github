package LeetCodeUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.IntStream;

public class Test {

    @org.junit.Test
    public void test() {

        for (int i = 0; i < 100000; ++i)
            random(10, 11);
        System.out.println(random(10, 12));

    }


    public String random(int i, int j) {
        StringBuilder sb = new StringBuilder();
        int len = (j - i) * 10 + 1;
        //System.out.println("len: " + len);
        int n = 1 + new Random().nextInt(len);
        //System.out.println("n: " + n);
        int r = (n - 1) / 10 + i;
        if (r == j) {
            sb.append(j).append(".0");
        } else {
            sb.append(r).append(".").append((n - 1)% 10);
        }
        return sb.toString();
    }

}

package LeetCodeUtils;

import org.junit.Test;

public class BitManipulation {

    /**
     *
     * @param i
     * @param length, the target length of bits
     * @return
     */
    public static String Integer2BitString(int i, int length) {
        StringBuilder sb = new StringBuilder();
        while (i >= 1) {
            int temp = i % 2;
            i = i / 2;
            sb.append(temp);
        }
        sb.append(i);
        for (int j = sb.length(); j < length; ++j)
            sb.append(0);
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(Integer2BitString(0, 8));
    }

}

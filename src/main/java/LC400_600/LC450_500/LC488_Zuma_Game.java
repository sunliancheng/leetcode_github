package LC400_600.LC450_500;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LC488_Zuma_Game {

    @Test
    public void test() {
        //StringBuilder sb = new StringBuilder("ABC");
        //sb.insert(3, 'd');
        //System.out.println(sb.toString());

        //findMinStep("G", "GGGGG");
        findMinStep("RBYYBBRRB", "YRBGB");
    }


    public int result = Integer.MAX_VALUE;

    public int findMinStep(String board, String hand) {
        dfs(board, hand, 0);
        if (result != Integer.MAX_VALUE) return result;
        return -1;
    }

    public void dfs(String s, String remainInsert, int num) {
        StringBuilder sb = new StringBuilder(s);
        if (remainInsert.length() == 0 || remainInsert.equals("")) {
            if (num != 0 && sb.toString().equals("") && result > num)
                result = num;
            return;
        }
        for (int i = 0; i <= sb.length(); ++i) {
            sb.insert(i, remainInsert.charAt(0));
            String ss = handle(sb.toString());
            dfs(ss, remainInsert.substring(1), 1 + num);
            sb.deleteCharAt(i);
        }

        dfs(s, remainInsert.substring(1), num);
    }

    public String handle(String s) {
        int[] temp = findMoreThanThree(s);
        while (temp[0] != -1) {
            s = remove(s, temp[0], temp[1]);
            temp = findMoreThanThree(s);
        }
        return s;
    }

    public String remove(String s, int idx, int count) {
        String result = s.substring(0, idx) + s.substring(idx + count);
        return result;
    }

    public int[] findMoreThanThree(String s) {
        int count = -1, i = 0; char c = 'a';
        for (; i < s.length(); ++i) {
            if (c != s.charAt(i)) {
                if (count >= 3) break;
                c = s.charAt(i);
                count = 1;
            } else count++;
        }
        if (count >= 3) return new int[]{(i - count), count};
        else return new int[]{-1, -1};
    }

}
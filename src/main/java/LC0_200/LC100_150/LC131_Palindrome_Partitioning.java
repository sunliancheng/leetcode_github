package LC0_200.LC100_150;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC131_Palindrome_Partitioning {

    @Test
    public void test() {
        List<Integer> ls = new ArrayList<>();
        List<Integer> ls2 = new ArrayList<>(ls);
        ls.add(1);
        System.out.println(ls.size());
    }


    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        List<List<String>> result = new ArrayList<>();
        dfs(result, s, 0, new ArrayList<>(), dp);
        return result;
    }

//    private void dfs(List<List<String>> result, String s, int start, ArrayList<String> currentList, boolean[][] dp) {
//        if (start >= s.length()) result.add(new ArrayList<>(currentList));
//        for (int end = start; end < s.length(); ++end) {
//            if (s.charAt(start) == s.charAt(end) && (end - start < 2 || dp[start + 1][end - 1])) {
//                dp[start][end] = true;
//                currentList.add(s.substring(start, end + 1));
//                dfs(result, s, end + 1, currentList, dp);
//                currentList.remove(currentList.size() - 1);
//            }
//        }
//    }

    private void dfs(List<List<String>> result, String s, int start, List<String> currentList, boolean[][] dp) {
        if (start >= s.length()) result.add(new ArrayList<>(currentList));
        for (int end = start; end < s.length(); ++end) {
            if (s.charAt(start) == s.charAt(end) && (end - start < 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                currentList.add(s.substring(start, end + 1));
                dfs(result, s, end + 1, currentList, dp);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

}

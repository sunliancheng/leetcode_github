package LC400_600.LC500_550;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC524_Longest_Word_In_Dictionary_Through_Deleting {

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        //list.add("aaa");
        list.add("aaa"); list.add("aa"); list.add("a");
        System.out.println(findLongestWord("aaa", list));
    }


    public String findLongestWord(String s, List<String> d) {
        String result = "";
        int[] arr = new int[d.size()];
        for (int i = 0; i < s.length(); ++i)
            for (int j = 0; j < d.size(); ++j) {
                String temp = d.get(j);
                if (arr[j] < temp.length() && temp.charAt(arr[j]) == s.charAt(i))
                    ++arr[j];
                if (arr[j] == temp.length())
                    if (result.length() < temp.length()) {
                        result = temp;
                    } else if (result.length() == temp.length() && result.compareTo(temp) < 0)
                        result = temp;
            }
        return result;
    }

    /**
     * Given a string and a string dictionary,
     * find the longest string in the dictionary
     * that can be formed by deleting some characters of the given string.
     *
     * If there are more than one possible results,
     * return the longest word with the smallest lexicographical order.
     *
     * If there is no possible result, return the empty string.
     *
     * Example 1:
     *
     * Input:
     * s = "abpcplea", d = ["ale","apple","monkey","plea"]
     *
     * Output:
     * "apple"
     */
}

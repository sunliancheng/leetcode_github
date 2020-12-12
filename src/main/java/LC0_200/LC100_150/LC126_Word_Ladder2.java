package LC0_200.LC100_150;

import com.sun.javafx.collections.MappingChange;
import org.junit.Test;

import java.util.*;

public class LC126_Word_Ladder2 {


    @Test
    public void test() {
        //System.out.println(calDis("lot", "dog"));
        String a = "dd";
        String b = "dd";
        Set<String> set = new HashSet<>();
        set.add(a);
        System.out.println(set.contains(b));

        List<String> path = new ArrayList<>();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot"); wordList.add("dog"); wordList.add("dot");

        findLadders("hot", "dog", wordList);
    }

    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String s : wordList)
            dict.add(s);
        if (!dict.contains(endWord))
            return ans;
        dict.remove(beginWord);
        dict.remove(endWord);
        Set<String> q1 = new HashSet<>(), q2 = new HashSet<>();
        q1.add(beginWord); q2.add(endWord);
        HashMap<String, List<String>> next = new HashMap<>();
        boolean reversed = false, found = false;

        while (!q1.isEmpty()) {
            Set<String> q = new HashSet<>();
            for (String w : q1) {
                char[] s = w.toCharArray();
                for (int i = 0; i < s.length; ++i) {
                    char ch = s[i];
                    for (int j = 0; j < 26; ++j) {
                        s[i] = (char) (j + 'a');
                        String tem = String.valueOf(s);
                        if (q2.contains(tem)) {
                            if (reversed) {
                                List<String> strs = next.getOrDefault(tem, new ArrayList<>());
                                strs.add(w);
                                next.put(tem, strs);
                            } else {
                                List<String> strs = next.getOrDefault(w, new ArrayList<>());
                                strs.add(tem);
                                next.put(w, strs);
                            }
                            found = true;
                        }
                        if (dict.contains(tem)) {
                            if (reversed) {
                                List<String> strs = next.getOrDefault(tem, new ArrayList<>());
                                strs.add(w);
                                next.put(tem, strs);
                            } else {
                                List<String> strs = next.getOrDefault(w, new ArrayList<>());
                                strs.add(tem);
                                next.put(w, strs);
                            }
                            q.add(tem);
                        }
                    }
                    s[i] = ch;
                }
            }
            if (found)
                break;
            for (String w : q)
                dict.remove(w);
            if (q.size() <= q2.size())
                q1 = q;
            else {
                reversed = !reversed;
                q1 = q2;
                q2 = q;
            }
        }
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(beginWord);
            backtracking(beginWord, endWord, next, path);
        }

        return ans;
    }

    void backtracking(String src, String dst, HashMap<String, List<String>> next,
                      List<String> path) {
        if (src.equals(dst)) {
            List<String> tem = new ArrayList<>();
            tem.addAll(path);
            ans.add(tem);
            return;
        }
        if (next.get(src) == null)
            return;
        for (String s : next.get(src)) {
            path.add(s);
            backtracking(s, dst, next, path);
            path.remove(s);
        }
    }




}

package LC0_200.LC100_150;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LC140_Word_Break2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, List<String>>());
    }

    List<String> DFS(String s, List<String> wordDict, HashMap<String, List<String>> map) {
        if(map.containsKey(s)) return map.get(s);
        List<String> re = new LinkedList<>();
        if(s.length() == 0){
            re.add("");
            return re;
        }
        for(String word : wordDict){
            if(s.startsWith(word)){
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                for(String sub : sublist)
                    re.add(sub == "" ? word: word + " " + sub);
            }
        }
        map.put(s, re);
        return re;
    }
}

package LC0_200.LC150_200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC187_Repeated_DNA_Sequences {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int len = s.length();
        for (int i = 0; i <= len - 10; ++i) {
            String ss = s.substring(i, i + 10);
            map.put(ss, map.getOrDefault(ss, 0) + 1);
        }
        for (String keys : map.keySet())
            if (map.get(keys) >= 2)
                list.add(keys);

        return list;
    }

}

package LC0_200.LC0_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC49_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<List<String>> temp = new ArrayList<List<String>>();

        for(int i = 0; i < strs.length; ++i){
            int flag = 0;
            char[] chs = strs[i].toCharArray();
            Arrays.sort(chs);
            String s = new String(chs);

            for(int j = 0; j < result.size(); ++j) {
                if(temp.get(j).contains(s)){
                    result.get(j).add(strs[i]);
                    flag = 1;
                }
            }
            if(flag == 0) {
                List<String> list = new ArrayList<>();
                list.add(s);
                List<String> list2 = new ArrayList<>();
                list2.add(strs[i]);
                temp.add(list);
                result.add(list2);
            }
        }

        return result;

    }
}

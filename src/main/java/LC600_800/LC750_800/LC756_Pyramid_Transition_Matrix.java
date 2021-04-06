package LC600_800.LC750_800;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

import javax.print.DocFlavor;
import java.nio.charset.CharacterCodingException;
import java.util.*;
import java.util.List;

public class LC756_Pyramid_Transition_Matrix {

    @Test
    public void test() {
        String[] ss = new String[]{"ACBACFG","BGD","AGG","AGC","AGB","CCE","EGB","CCG","EGE","EGD","DCF","FGE","FGB","BFD","DBD","DBF","FFE","FFB","FDA","FDC","GBE","FDE","BEA","EGC","AEC","CCD","EEE","EED","DEB","DEE","DEF","EEB","CEE","BDC","GEC","GEB","GCA","GCB","BDA","GCG","AFF","DDB","EFB","DDG","DDF","DDE","CBF","ACB","ACG","ACF","BCD","BCC","DGB","EFD","CGD","CGG","FCB","GGF","FCD","FCF","FEB","BBF","BBE","CDE","ADA","DFE","DFG","DFB","CDD","EDC","CDF","EDD","FBC","FBF","AAD","AAF","AAB","BAG","BAD","CAG","CAF","DAB","DAC","EEC","GAE","FAG","ABA","EBC","CFG","GFD"};
        List<String> list = new ArrayList<>();
        for (String s : ss) list.add(s);

        //list.add("BCG"); list.add("CDE"); list.add("GEA"); list.add("FFF");
        System.out.println(pyramidTransition("ACBACFG", list));
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        char[] cs = new char[bottom.length() - 1];
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String sub = s.substring(0, 2);
            List<Character> list = map.getOrDefault(sub, new ArrayList<>());
            list.add(s.charAt(2));
            map.put(sub, list);
        }
        return dfs(bottom, map, 0, cs, new HashMap<>());
    }

    public boolean dfs(String bottom, Map<String, List<Character>> allowed, int idx, char[] cs, Map<String, Boolean> memo) {
        if (bottom.length() == 1) return true;
        if (memo.containsKey(bottom)) return memo.get(bottom);
        if (idx == bottom.length() - 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(cs);
            boolean result = dfs(sb.toString(), allowed, 0, new char[sb.length() - 1], memo);
            memo.put(sb.toString(), result);
            return result;
        }

        boolean flag = false;
        for (int i = idx; i < bottom.length() - 1; ++i) {
            String sub = bottom.substring(i, i + 2);
            List<Character> list = allowed.getOrDefault(sub, null);
            if (list == null || list.size() == 0) {
                memo.put(bottom, false);
                return false;
            }
            for (char c : list) {
                cs[i] = c;
                flag |= dfs(bottom, allowed, 1 + idx, cs, memo);
                if (flag) {
                    memo.put(bottom, true);
                    return true;
                }
            }
        }
        return flag;
    }

}

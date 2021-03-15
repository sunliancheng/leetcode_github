package LC400_600.LC500_550;

import org.junit.Test;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class LC546_Remove_Boxes {

    @Test
    public void test() {
        //List<Integer> list = new ArrayList<>();
        //list.add(2); list.add(2); list.add(1); list.add(2); list.add(1);
        //List<Integer> delete = delete(list, 0);

        System.out.println(removeBoxes(new int[]{1,3,2,2,2,3,4,3,1}));
        //List<Integer> list = new ArrayList<>();
        //for (int i : new int[]{1,3,2,2,2,3,4,3,1}) list.add(i);
        //list = delete(list, 2);
        //for (int i : list) System.out.println(i);
        //System.out.println(removeBoxes(new int[]{1,2,1}));
    }

    public int removeBoxes(int[] boxes) {
        List<Integer> list = new ArrayList<>();
        for (int i : boxes) list.add(i);
        Map<List<Integer>, Integer> map = new HashMap<>();
        return remove(list, map);
    }

    public int remove(List<Integer> list, Map<List<Integer>, Integer> map) {
        if (map.containsKey(list)) return map.get(list);
        if (list.size() == 0 || list.size() == 1) return list.size();
        int re = 0;
        for (int i = 0; i < list.size(); ++i) {
            List<Integer> tem = delete(list, i);
            int n = list.size() - tem.size();
            i += n - 1;
            n = n * n;
            int fi = n + remove(tem, map);
            re = Math.max(re, fi);

        }
        map.put(list, re);
        return re;
    }

    public List<Integer> delete(List<Integer> list, int start) {
        List<Integer> tem = new ArrayList<>();
        boolean flag = false;
        int first = list.get(start), end = start;
        for (int i = 0; i < list.size(); ++i) {
            if (!flag && i > start && list.get(i) == first) end = i;
            else if (i > start) flag = true;
            if (i < start || i > end) tem.add(list.get(i));
        }
        return tem;
    }




}

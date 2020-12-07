package LC600_800.LC750_800;

import LeetCodeUtils.MyPrint;
import org.junit.Test;

import javax.management.ObjectName;
import java.util.*;

public class LC763_Partition_Labels {

    @Test
    public void test() {
        System.out.println(partitionLabels("eaaaabaaec").toString());
    }


    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < S.length(); ++i) {
            if (map.containsKey(S.charAt(i))) {
                int[] value = map.get(S.charAt(i));
                value[1] = i;
            } else {
                int[] value = new int[]{i, i};
                map.put(S.charAt(i), value);
            }
        }

        int[][] obj = map.values().toArray(new int[0][]);
        Arrays.sort(obj, (a, b) -> { return Integer.compare(a[0], b[0]); });
        int s = obj[0][0], e = obj[0][1];
        for (int i = 1; i < obj.length; ++i) {
            if (obj[i][0] > e) {
                res.add(e - s + 1);
                s = obj[i][0];
                e = obj[i][1];
            } else
                if (obj[i][1] > e)
                    e = obj[i][1];
            if (i == obj.length - 1)
                res.add(e - s + 1);
        }
        return res;
    }

}

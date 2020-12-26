package LC800_1000.LC850_900;

import org.junit.Test;

import java.util.*;

public class LC870_Advantage_Shuffle {

    @Test
    public void test() {
        advantageCount(new int[]{2,7,11,15}, new int[]{1,10,4,11});
    }

    public int[] advantageCount(int[] A, int[] B) {

        Arrays.sort(A);
        List<Integer> list = new ArrayList<>();
        int[] result = new int[A.length];
        Set<Integer> empty = new HashSet<>();
        for (int i : A)
            list.add(i);
        int max = 0, level = 0;
        for (int i = 0; i < B.length; ++i) {
            int tem = -1;
            for (int j = 0; j < list.size(); ++j) {
                if (list.get(j) > B[i]) {
                    ++max;
                    tem = j;
                    result[i] = list.get(j);
                    break;
                }
            }
            if (tem != -1)
                list.remove(tem);
            else
                empty.add(i);
        }
        if (empty.size() != 0)
            for (int i : empty) {
                result[i] = list.get(0);
                list.remove(0);
            }
        return result;
    }

}

package LC0_200.LC100_150;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 2020-09-22 11:28 PM at Hangzhou
 */
public class LC119_Pascal_Triangle2 {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i <= rowIndex + 1; ++i) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 1; j <= i; ++j) {
                if (j == 1 || j == i) {
                    temp.add(1);
                } else
                    temp.add(res.get(i - 2).get(j - 2) + res.get(i - 2).get(j - 1));
            }
            res.add(temp);
        }
        return res.get(res.size() - 1);
    }

    @Test
    public void test() {
        System.out.println(getRow(3));
    }

}

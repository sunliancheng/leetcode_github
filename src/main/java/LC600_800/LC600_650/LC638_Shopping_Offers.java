package LC600_800.LC600_650;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC638_Shopping_Offers {

    @Test
    public void test() {
        List<Integer> price = new ArrayList<>();
        price.add(2); price.add(3); price.add(4);
        List<List<Integer>> special = new ArrayList<>();
        List<Integer> count1 = new ArrayList<>();
        count1.add(1); count1.add(1); count1.add(0); count1.add(4);
        List<Integer> count2 = new ArrayList<>();
        count2.add(2); count2.add(2); count2.add(1); count2.add(9);
        special.add(count1); //special.add(count2);

        List<Integer> needs = new ArrayList<>();
        needs.add(1); needs.add(2); needs.add(1);

        System.out.println(shoppingOffers(price, special, needs));

    }


    public int shoppingOffers(List < Integer > price, List < List < Integer >> special, List < Integer > needs) {
        Map < List < Integer > , Integer > map = new HashMap();
        return shopping(price, special, needs, map);
    }

    public int shopping(List < Integer > price, List < List < Integer >> special, List < Integer > needs, Map < List < Integer > , Integer > map) {
        if (map.containsKey(needs))
            return map.get(needs);
        int j = 0, res = dot(needs, price);
        for (List < Integer > s: special) {
            ArrayList < Integer > clone = new ArrayList < > (needs);
            for (j = 0; j < needs.size(); j++) {
                int diff = clone.get(j) - s.get(j);
                if (diff < 0)
                    break;
                clone.set(j, diff);
            }
            if (j == needs.size())
                res = Math.min(res, s.get(j) + shopping(price, special, clone, map));
        }
        map.put(needs, res);
        return res;
    }

    public int dot(List < Integer > a, List < Integer > b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }



}

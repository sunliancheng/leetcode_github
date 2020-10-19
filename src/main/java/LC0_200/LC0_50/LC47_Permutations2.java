package LC0_200.LC0_50;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LC47_Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        for(int num : nums){
            result = insert(num, result);
        }
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        re.addAll(result);
        HashSet set = new HashSet(re);
        re.clear();
        re.addAll(set);
        return re;
    }

    private List<LinkedList<Integer>> insert(int num, List<LinkedList<Integer>> result) {
        List<LinkedList<Integer>> re = new ArrayList<LinkedList<Integer>>();
        if(result.size() == 0){
            LinkedList<Integer> ls = new LinkedList<>();
            ls.add(num);
            re.add(ls);
            return re;
        }
        for(LinkedList<Integer> ls : result) {
            for(int i = 0; i <= ls.size(); ++i){
                LinkedList<Integer> temp1 = copyList(ls);
                temp1.add(i , num);
                re.add(temp1);
            }
        }
        return re;
    }

    private LinkedList<Integer> copyList(LinkedList<Integer> ls) {
        LinkedList<Integer> ans = new LinkedList<>();
        ans.addAll(ls);
        return ans;
    }
}

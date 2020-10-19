package LC0_200.LC0_50;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC46_Permutations {
    public List<List<Integer>> permute(int[] nums) {

        List<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        for(int num : nums){
            result = insert(num, result);
        }

        List<List<Integer>> re = new ArrayList<List<Integer>>();
        re.addAll(result);
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

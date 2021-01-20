package LC0_200.LC0_50;

import LeetCodeUtils.MyMatrix;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC46_Permutations {

//    public List<List<Integer>> permute(int[] nums) {
//
//        List<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
//        for(int num : nums){
//            result = insert(num, result);
//        }
//
//        List<List<Integer>> re = new ArrayList<List<Integer>>();
//        re.addAll(result);
//        return re;
//    }
//
//    private List<LinkedList<Integer>> insert(int num, List<LinkedList<Integer>> result) {
//
//        List<LinkedList<Integer>> re = new ArrayList<LinkedList<Integer>>();
//        if(result.size() == 0){
//            LinkedList<Integer> ls = new LinkedList<>();
//            ls.add(num);
//            re.add(ls);
//            return re;
//        }
//        for(LinkedList<Integer> ls : result) {
//            for(int i = 0; i <= ls.size(); ++i){
//                LinkedList<Integer> temp1 = copyList(ls);
//                temp1.add(i , num);
//                re.add(temp1);
//            }
//        }
//        return re;
//    }
//
//    private LinkedList<Integer> copyList(LinkedList<Integer> ls) {
//        LinkedList<Integer> ans = new LinkedList<>();
//        ans.addAll(ls);
//        return ans;
//    }

    @Test
    public void test() {
        permute(MyMatrix.OneDIntMatrixAdapter("[1,2,3]"));
        int a = 1, b = 3;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, 0, result);
        return result;
    }

    void backtracking(int[] nums, int level, List<List<Integer>> ans) {
        if (level == nums.length - 1) {
            List<Integer> tem = new ArrayList<>();
            for (int i : nums)
                tem.add(i);
            ans.add(tem);
            return;
        }
        for (int i = level; i < nums.length; ++i) {
            int tem = nums[i];
            nums[i] = nums[level]; nums[level] = tem;
            backtracking(nums, level + 1, ans);
            nums[level] = nums[i]; nums[i] = tem;
        }
    }

}

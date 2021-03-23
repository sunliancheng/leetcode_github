package LC0_200.LC50_100;

import org.junit.Test;

import java.util.*;

public class LC90_Subsets2 {

    // reference:https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        if (start > nums.length) return;
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; ++i) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    @Test
    public void test() {
        List<List<Integer>> ls = subsetsWithDup(new int[]{1, 2, 2});
        for (List<Integer> l : ls) {
            for (Integer i : l)
                System.out.print(i);
            System.out.println();
        }
    }


    /**
     * Given a collection of integers that might contain duplicates, nums,
     * return all possible subsets (the power set).
     *
     * Note: The solution set must not contain duplicate subsets.
     *
     * Example:
     *
     * Input: [1,2,2]
     * Output:
     * [
     *   [2],
     *   [1],
     *   [1,2,2],
     *   [2,2],
     *   [1,2],
     *   []
     * ]
     */

    /**
     *  set<vector<int>>sett;
     *     vector<vector<int>> subsetsWithDup(vector<int>& nums) {
     *         int n=nums.size();
     *         sort(nums.begin(),nums.end()); //to avoid duplicates
     *         int total=1<<n;
     *         vector<vector<int>> res;
     *         vector<int> temp;
     *         for(int mask=0;mask<total;mask++){
     *             for(int i=0;i<n;i++){
     *                 if((mask & (1<<i))!=0){
     *                     temp.push_back(nums[i]);
     *                 }
     *             }
     *             if(sett.find(temp)==sett.end()){
     *                 sett.insert(temp);
     *                 res.push_back(temp);
     *             }
     *             temp.clear();
     *         }
     *         return res;
     *     }
     */
}

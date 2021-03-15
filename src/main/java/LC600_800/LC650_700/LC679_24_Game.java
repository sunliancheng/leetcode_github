package LC600_800.LC650_700;

import org.junit.Test;

import java.util.ArrayList;

public class LC679_24_Game {

    @Test
    public void test() {
        System.out.println(judgePoint24(new int[]{4,1,8,7}));
    }

    public boolean judgePoint24(int[] nums) {
        ArrayList A = new ArrayList<Double>();
        for (int v : nums) A.add((double) v);
        return solve(A);
    }

    private boolean solve(ArrayList<Double> nums) {
        if (nums.size() == 0) return false;
        // if the only left == 24, return true;
        if (nums.size() == 1 && Math.abs(nums.get(0) - 24) < 1e-6) return true;

        for (int i = 0; i < nums.size(); ++i) {
            for (int j = 0; j < nums.size(); ++j) {
                if (i == j) continue;
                ArrayList<Double> B = new ArrayList();
                B.addAll(nums);
                B.remove((Double) nums.get(i));
                B.remove((Double) nums.get(j));
                Double ans1 = nums.get(i) - nums.get(j), ans2 = nums.get(i) + nums.get(j), ans3 = nums.get(i) * nums.get(j), ans4 = nums.get(i) / nums.get(j);
                B.add(ans1); if(solve(B)) return true; B.remove(ans1);
                B.add(ans2); if(solve(B)) return true; B.remove(ans2);
                B.add(ans3); if(solve(B)) return true; B.remove(ans3);
                B.add(ans4); if(solve(B)) return true; B.remove(ans4);
            }
        }
        return false;
    }

}

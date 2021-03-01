package LC200_400.LC200_250;

public class LC219_Contains_Duplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j <= i + k && j < nums.length; ++j) {
                if (nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

}

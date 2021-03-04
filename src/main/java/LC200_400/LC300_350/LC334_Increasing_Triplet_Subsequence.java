package LC200_400.LC300_350;

public class LC334_Increasing_Triplet_Subsequence {

    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i <= a) {
                a = i;
            } else if (i <= b) {
                b = i;
            } else
                return true;
        }
        return false;
    }

}

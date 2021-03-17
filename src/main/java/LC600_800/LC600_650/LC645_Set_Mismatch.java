package LC600_800.LC600_650;

public class LC645_Set_Mismatch {

    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[nums.length + 1];
        for (int i : nums) {
            arr[i]++;
        }
        int[] re = new int[2];
        for (int i = 1; i <= nums.length; ++i) {
            if (arr[i] == 2) re[0] = i;
            if (arr[i] == 0) re[1] = i;
        }
        return re;
    }

}

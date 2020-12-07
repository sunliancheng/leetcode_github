package LC0_200.LC100_150;

import org.junit.Test;

import java.util.Arrays;

public class LC135_Candy {

    @Test
    public void test() {
        System.out.println(candy(new int[]{1, 0, 2}));
    }

    public int candy(int[] ratings) {
        if (ratings.length < 2)
            return ratings.length;
        int[] arr = new int[ratings.length];
        Arrays.fill(arr, 1);
        for (int i = 1; i < ratings.length; ++i)
            arr[i] = (ratings[i] > ratings[i - 1] ? arr[i - 1] + 1 : arr[i]);

        for (int i = ratings.length - 1; i > 0; --i)
            if (ratings[i] < ratings[i - 1])
                arr[i - 1] = Math.max(arr[i - 1], arr[i] + 1);

        int ans = 0;
        for (int a : arr)
            ans += a;
        return ans;
    }

}

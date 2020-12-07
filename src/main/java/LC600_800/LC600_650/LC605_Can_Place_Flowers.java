package LC600_800.LC600_650;

public class LC605_Can_Place_Flowers {


    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int ans = 0;
        for (int i = 0; i < flowerbed.length; ++i) {
            if (checkIfSatisfied(flowerbed, i))
                ans++;
        }
        return (ans >= n ? true : false);
    }

    public boolean checkIfSatisfied(int[] arr, int i) {
        if (arr[i] == 1)
            return false;
        else {
            if (i - 1 >= 0)
                if (arr[i - 1] == 1)
                    return false;
            if (i + 1 < arr.length)
                if (arr[i + 1] == 1)
                    return false;
        }
        arr[i] = 1;
        return true;
    }

}

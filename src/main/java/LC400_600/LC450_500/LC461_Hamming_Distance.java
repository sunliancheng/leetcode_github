package LC400_600.LC450_500;

public class LC461_Hamming_Distance {

    public int hammingDistance(int x, int y) {
        int diff = x ^ y, ans = 0;
        while (diff > 0) {
            ans += diff & 1;
            diff >>= 1;
        }
        return ans;
    }

}

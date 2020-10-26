package LC0_200.LC50_100;

public class LC69_Sqrt {
    public int mySqrt(int x) {

        int i = (new Double(Math.sqrt(x))).intValue();

        if(i*i > x) i -= 1;

        return i;

    }
}

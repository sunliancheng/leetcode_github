package LC0_200.LC0_50;

public class LC50_Pow {
    public double myPow(double x, int n) {

        if(n == 0) return 1;
        //if(x == 0) return 0;
        //if(x == 1) return 1;
        if(n == 1) return x;

        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }

        if(n < 0){
            n = -n;
            x = 1/x;
        }

        return n % 2 ==0 ? myPow(x*x, n/2) : myPow(x*x, n/2)*x;

    }
}

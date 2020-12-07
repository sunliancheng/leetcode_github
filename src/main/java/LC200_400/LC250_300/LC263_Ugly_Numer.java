package LC200_400.LC250_300;

public class LC263_Ugly_Numer {
    public boolean isUgly(int num) {
        if(num == 0)
            return false;
        if(num == 1)
            return true;
        int n = num;
        while(n % 2 == 0)
            n = n / 2;
        while(n % 3 == 0)
            n = n / 3;
        while(n % 5 == 0)
            n = n / 5;
        if(n == 1)
            return true;
        else
            return false;
    }
}

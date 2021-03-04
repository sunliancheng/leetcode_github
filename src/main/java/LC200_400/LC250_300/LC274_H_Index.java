package LC200_400.LC250_300;

import org.junit.Test;

import java.util.Arrays;

public class LC274_H_Index {

    @Test
    public void test() {
        hIndex(new int[]{1,2});
    }

    public int hIndex(int[] c) {
        if(c.length == 0)
            return 0;
        Arrays.sort(c);

        int l = 0;
        int r = c.length-1;
        int   m  = 0;

        while(true){
            m = (l + r )/2;
            if(c[m] == (c.length - m)){
                return c[m];
            }else if(c[m] > (c.length - m)){
                r = m-1;
                if(r < l) return c.length - m;
            }else{
                l = m+1;
                if(l > r) return c.length - l;
            }
        }
    }

}

package LC0_200.LC50_100;

import org.junit.Test;

public class LC91_Decode_Ways {

    @Test
    public void test() {
        //System.out.println(numDecodings("123123"));
        //System.out.println(numDecodings("1201234"));
        //System.out.println(numDecodings("1212"));
        //System.out.println(numDecodings("256"));
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("2101"));
//        System.out.println(numDecodings("1123"));
        System.out.println(numDecodings("2611055971756562"));

    }
    public int numDecodings(String s) {
        int[] dp= new int[s.length() + 1];
        dp[0]=1;
        dp[1]= s.charAt(0)=='0' ? 0 : 1;
        for(int i = 2; i < dp.length; i++){
            int oneDigit= Integer.valueOf(s.substring(i - 1, i));
            int twoDig= Integer.valueOf(s.substring(i - 2, i));

            if(oneDigit >= 1)
                dp[i] += dp[i - 1];

            if(twoDig >= 10 && twoDig <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }

}

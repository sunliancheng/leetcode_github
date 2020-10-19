package LC0_200.LC0_50;

public class LC5_Longest_Palindromic_Substring {

    public String longestPalindrome(String s) {
        if(s.length() == 0)
            return "";
        if(s.length() == 1)
            return s;
        String result = "";
        for(int i = 0; i < s.length(); ++i) {
            int low = i, high = i;
            if(result == "")
                result = s.substring(i, i + 1);
            int flag = 0;
            while(low >= 0 && high < s.length())

                if(low - 1 >= 0 && high + 1 < s.length() && s.charAt(low - 1) == s.charAt(high + 1)) {
                    if(result.length() < s.substring(low - 1, high + 2).length())
                        result = s.substring(low - 1, high + 2);
                    if(s.charAt(i) != s.charAt(low - 1))
                        flag = 1;
                    low--; high++;
                    continue;
                } else if(low - 1 >= 0 && s.charAt(low - 1) == s.charAt(high)) {
                    if(flag == 1)
                        break;
                    if(result.length() < s.substring(low - 1, high + 1).length())
                        result = s.substring(low - 1, high + 1);
                    low--; continue;
                } else if(high + 1 < s.length() && s.charAt(low) == s.charAt(high + 1)) {
                    if(flag == 1)
                        break;
                    if(result.length() < s.substring(low, high + 2).length())
                        result = s.substring(low, high + 2);
                    high++; i = high; continue;
                } else
                    break;
        }
        return result;
    }

}

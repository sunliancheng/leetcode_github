package LC0_200.LC0_50;

public class LC6_Zigzag_Conversion {

    public String convert(String s, int numRows) {
        if(s.length() == 0 || s.length() == 1 || numRows == 1)
            return s;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; ++i) {
            int tem = i;
            while(tem < s.length()) {

                if(i == 0 || i == numRows - 1)
                    sb.append(s.charAt(tem));
                else {
                    int temp = 2 * (numRows - 1 - i) + tem;
                    sb.append(s.charAt(tem));
                    if(temp < s.length())
                        sb.append(s.charAt(temp));
                }
                tem += (2 * numRows - 2);
            }
        }
        return sb.toString();
    }

}

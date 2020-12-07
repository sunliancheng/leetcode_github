package LC0_200.LC150_200;

public class LC171_Excel_Sheet_Column_Number {
    public int titleToNumber(String s) {
        int result = 0;

        for(int i = 0; i < s.length(); ++i){
            result = result * 26 + s.charAt(i) - 'A' + 1;
        }
        return result;
    }
}

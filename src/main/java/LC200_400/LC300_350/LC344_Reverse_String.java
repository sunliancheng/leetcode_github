package LC200_400.LC300_350;

public class LC344_Reverse_String {

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; ++i) {
            char tem = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - i] = tem;
        }
    }


}

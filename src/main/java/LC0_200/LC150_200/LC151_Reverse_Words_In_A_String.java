package LC0_200.LC150_200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LC151_Reverse_Words_In_A_String {

    @Test
    public void test() {
        reverseWords("a good   example");
        List<String> op = op(" hello world ");
    }

    public String reverseWords(String s) {
        List<String> op = op(s);
        StringBuilder sb = new StringBuilder();
        for (int i = op.size() - 1; i >= 0; --i) {
            sb.append(op.get(i));
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public List<String> op(String s) {
        List<String> result = new ArrayList<>();
        s = s.trim();
        int i = 0; boolean isNone = false; StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                isNone = false;
                sb.append(s.charAt(i));
                ++i;
            } else {
                if (isNone) {
                    i++;
                } else {
                    isNone = true;
                    i++;
                    result.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        if (sb.capacity() != 0) result.add(sb.toString());
        return result;
    }

}

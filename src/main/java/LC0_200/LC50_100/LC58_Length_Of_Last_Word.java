package LC0_200.LC50_100;

public class LC58_Length_Of_Last_Word {
    public int lengthOfLastWord(String s) {
        String[] ss = s.split(" ");
        if (ss.length == 0)
            return 0;
        return ss[ss.length - 1].length();
    }
}

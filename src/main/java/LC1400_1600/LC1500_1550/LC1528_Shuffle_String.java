package LC1400_1600.LC1500_1550;

public class LC1528_Shuffle_String {

    public String restoreString(String s, int[] indices) {
        char[] re = new char[s.length()];
        for (int i = 0; i < indices.length; ++i) {
            re[indices[i]] = s.charAt(i);
        }
        return new String(re);
    }

}

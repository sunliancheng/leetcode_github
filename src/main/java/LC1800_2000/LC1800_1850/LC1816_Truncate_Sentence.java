package LC1800_2000.LC1800_1850;

public class LC1816_Truncate_Sentence {

    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");
        for (int i = 0; i < k; ++i) {
            sb.append(ss[i]);
            if (i != k - 1) sb.append(" ");
        }
        return sb.toString();
    }

}

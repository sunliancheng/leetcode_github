package LC0_200.LC0_50;

/**
 *  2020-09-20 7:28 PM at Hangzhou
 */
public class LC38_Count_And_Say {

    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++)
            res = getNext(res);
        return res;
    }

    public String getNext(String cur) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cur.length(); i++) {
            if (i > 0 && cur.charAt(i) != cur.charAt(i - 1)) {
                sb.append(count);
                sb.append(cur.charAt(i - 1));
                count = 1;
            } else
                count += 1;
        }
        sb.append(count);
        sb.append(cur.charAt(cur.length() - 1));
        return sb.toString();
    }

}

package LC0_200.LC0_50;

public class LC14_Longest_Common_Prefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        String prefix = find2Preix(strs[0], strs[1]);
        for (int i = 2; i < strs.length; ++i) {
            if (!strs[i].startsWith(prefix)) {
                prefix = find2Preix(prefix, strs[i]);
            }
        }
        return prefix;
    }

    public String find2Preix(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (s1.length() > s2.length() ? s2.length() : s1.length()); ++i) {
            sb.append(s1.charAt(i));
            if (s2.startsWith(sb.toString())) {
                continue;
            } else {
                sb.deleteCharAt(sb.length() - 1);
                break;
            }
        }
        return sb.toString();
    }

}

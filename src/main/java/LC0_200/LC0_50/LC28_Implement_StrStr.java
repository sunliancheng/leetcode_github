package LC0_200.LC0_50;

public class LC28_Implement_StrStr {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        if(needle.equals(haystack.substring(0, needle.length()))) return 0;
        int length = needle.length();
        int res = hashString(haystack, length);
        int ans_hash = hashString(needle, needle.length());
        for(int i = 0; i < haystack.length() - length ; ++i){
            res = hashString(haystack, i + length, length, res);
            if(res == ans_hash) {
                if(needle.equals(haystack.substring(i + 1, i + 1 + length)) ) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

    public int hashString(String s, int index, int length, int res){
        int base = 256;
        int temp = s.charAt(index - length);
        for(int i = 0; i < length - 1; ++i) {
            temp = temp * base % 101;
        }
        res = (res + 101 - temp) * base + s.charAt(index);
        return res % 101;
    }

    public int hashString(String s, int length){
        int base = 256;
        int result = 0;
        for(int i = 0; i < length; ++i){
            result = ((result * base) % 101 + s.charAt(i)) % 101;
        }
        return result;
    }
}

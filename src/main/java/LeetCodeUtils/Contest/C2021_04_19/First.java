package LeetCodeUtils.Contest.C2021_04_19;

public class First {

    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) return false;
        boolean[] arr = new boolean[26];
        int count = 0;
        for (int i = 0; i < sentence.length(); ++i) {
            char c = sentence.charAt(i);
            if (arr[c - 'a'] == false) count++;
            arr[c - 'a'] = true;
        }
        return count == 26;
    }

}

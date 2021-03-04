package LC200_400.LC300_350;

import java.util.HashSet;
import java.util.Set;

public class LC345_Reverse_Vowels_Of_A_String {

    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');vowels.add('u');vowels.add('o');vowels.add('i');vowels.add('e');
        vowels.add('A');vowels.add('U');vowels.add('O');vowels.add('I');vowels.add('E');
        int i =0, j = s.length() -1;
        char[] ss = s.toCharArray();
        while(i < j){
            if(!vowels.contains(ss[i])) i++;
            else if(!vowels.contains(ss[j])) j--;
            else {
                char t = ss[i];
                ss[i] = ss[j];
                ss[j] = t;
                i++; j--;
            }
        }
        return String.valueOf(ss);
    }

}

package LeetCodeUtils.Interview;

import java.util.*;

public class Demotest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int n = map.keySet().size(), i = 0;
        for (char c : map.keySet()) {
            System.out.print(c + "=" + map.get(c));
            if (i != n - 1) System.out.print(" ");
            ++i;
        }
    }
}

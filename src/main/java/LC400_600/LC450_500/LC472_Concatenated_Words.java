package LC400_600.LC450_500;

import org.junit.Test;

import java.util.*;

public class LC472_Concatenated_Words {

    @Test
    public void test() {
        System.out.println(findAllConcatenatedWordsInADict(new String[] {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"}));
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        if (words.length == 0 || words[0].equals("")) return result;
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        Map<String, Integer> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        for (String word : words)
            set.add(word);

        int min = words[0].length();

        for (String s : words) {
            stack.add(s);
            while (stack.size() > 0) {
                String peek = stack.peek();
                if (map.getOrDefault(peek, -1) >= 1) {
                    stack.pop();
                    continue;
                }
                if (peek.length() < 2 * min && !set.contains(peek)) {
                    stack.pop();
                    map.put(peek, 0);
                    continue;
                }
                int count = 0;
                for (String word : words) {
                    if (count >= 2) break;
                    if (peek.startsWith(word)) {
                        if (word.equals(peek)) {
                            count += 1;
                            break;
                        } else if (peek.length() >= 2 * min) {
                            String next = peek.substring(word.length());
                            int t = map.getOrDefault(next, -1);
                            if (t != -1 && t != 0) count += t;
                            else if (count < 2 && next.length() >= 2 * min || set.contains(next)) stack.push(next);
                        }
                    }
                }

                if (stack.peek().equals(peek)) {
                    stack.pop();
                    map.put(peek, count);
                }
            }
        }

        for (String k : map.keySet())
            if (set.contains(k) && map.get(k) > 1) result.add(k);

        return result;
    }





}

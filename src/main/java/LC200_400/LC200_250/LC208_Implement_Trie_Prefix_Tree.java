package LC200_400.LC200_250;

import org.junit.Test;

public class LC208_Implement_Trie_Prefix_Tree {

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.startsWith("app"));
    }
}

class Trie {

    public WordNode dic = null;

    /** Initialize your data structure here. */
    public Trie() {
        dic = new WordNode();
    }

    public void insert(String word) {
        WordNode current = dic;
        for (int i = 0; i < word.length(); ++i) {
            int offSet = word.charAt(i) - 'a';
            if (current.list[offSet] == null) {
                current.list[offSet] = new WordNode();
            }
            current = current.list[offSet];
        }
        current.isEndHere = true;
    }

    public boolean search(String word) {
        return search(word, 0, dic);
    }

    private boolean search(String word, int start, WordNode cur) {
        if (start >= word.length() || cur == null) return false;
        char var = word.charAt(start);
        if (var == '.') {
            boolean isUsed = false;
            for (int j = 0; j < 26; ++j) {
                boolean flag = search(word, start + 1, cur.list[j]);
                if (flag) return true;
                if (cur.list[j] != null && cur.list[j].isEndHere) isUsed = true;
            }
            if (start == word.length() - 1 && isUsed) return true;
        } else if (cur.list[var - 'a'] == null)
            return false;
        else if (start == word.length() - 1 && cur.list[var - 'a'].isEndHere)
            return true;
        else return search(word, 1 + start, cur.list[var - 'a']);
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return search2(prefix, 0, dic);
    }

    private boolean search2(String word, int start, WordNode cur) {
        if (start >= word.length() || cur == null) return false;
        char var = word.charAt(start);
        if (var == '.') {
            boolean isUsed = false;
            for (int j = 0; j < 26; ++j) {
                boolean flag = search2(word, start + 1, cur.list[j]);
                if (flag) return true;
                if (cur.list[j] != null) isUsed = true;
            }
            if (start == word.length() - 1 && isUsed) return true;

        } else if (cur.list[var - 'a'] == null)
            return false;
        else if (start == word.length() - 1)
            return true;
        else return search2(word, 1 + start, cur.list[var - 'a']);
        return false;
    }

    public class WordNode {
        boolean isEndHere = false;
        WordNode[] list = new WordNode[26];
    }
}
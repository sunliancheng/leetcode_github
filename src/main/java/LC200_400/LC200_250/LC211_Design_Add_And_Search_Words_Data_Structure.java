package LC200_400.LC200_250;

import org.junit.Test;

public class LC211_Design_Add_And_Search_Words_Data_Structure {

    @Test
    public void test() {
        WordDictionary wordDictionary = new WordDictionary();
        WordDictionary.WordNode dic = wordDictionary.dic;
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        //wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("dad"));
        System.out.println();
    }
}


class WordDictionary {

    public WordNode dic = null;

    /** Initialize your data structure here. */
    public WordDictionary() {
        dic = new WordNode();
    }

    public void addWord(String word) {
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

    public class WordNode {
        boolean isEndHere = false;
        WordNode[] list = new WordNode[26];
    }
}


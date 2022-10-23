package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountWordsOneOccurrence {

    public static void main(String[] args) {
        String[] word1 = {"leetcode", "is", "amazing", "as", "is", "is"};
        String[] word2 = {"amazing", "leetcode", "is"};
        new CountWordsOneOccurrence().countWords(word1, word2);
    }

    public int countWords(String[] words1, String[] words2) {
        int cnt = 0;
        Map<String, Integer> wordMap1 = new HashMap<>();
        Map<String, Integer> wordMap2 = new HashMap<>();

        for (int i = 0; i < words1.length; i++) {
            if (wordMap1.get(words1[i]) != null) {
                wordMap1.put(words1[i], wordMap1.get(words1[i]) + 1);
            } else {
                wordMap1.put(words1[i], 1);
            }
        }
        for (int i = 0; i < words2.length; i++) {
            if (wordMap2.get(words2[i]) != null) {
                wordMap2.put(words2[i], wordMap2.get(words2[i]) + 1);
            } else {
                wordMap2.put(words2[i], 1);
            }
        }

        for (String key1 : wordMap1.keySet()) {
            for (String key2 : wordMap2.keySet()) {
                if (key1.equals(key2)
                        && wordMap1.get(key1) == 1
                        && wordMap2.get(key2) == 1) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

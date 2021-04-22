package top50_graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
       String[] words = {"hot", "dot", "lot" , "log", "cog"};
       List<String> wordList = Arrays.asList(words);

        System.out.println(solve("hit", "cog", wordList));
    }

    public static int solve(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);

        queue.offer(beginWord);
        dict.remove(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word == null) {
                    continue;
                }
                if (word.equals(endWord)) {
                    return level;
                }
                for (String neighbor : neighbors(word, dict)) {
                    queue.offer(neighbor);
                }
            }
            level++;
        }

        return level;
    }

    public static List<String> neighbors(String s, Set<String> dict) {
        List<String> res = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();

            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch; // ait ~ zit

                String word = new String(chars);
                if (dict.contains(word)) {
                    res.add(new String(chars));
                    //dict.remove(word);
                }
            }
        }

        return res;
    }
}

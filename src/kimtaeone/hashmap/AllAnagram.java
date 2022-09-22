package kimtaeone.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AllAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        solution(s, t);
    }

    private static void solution(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        char[] sChars = s.toCharArray();
        int sLen = s.length();
        int tLen = t.length();
        int lt = 0;
        for (int i = 0; i < tLen - 1; i++) {
            sMap.put(sChars[i], sMap.getOrDefault(sChars[i], 0) + 1);
        }

        int cnt = 0;
        for (int rt = tLen - 1; rt < sLen; rt++) {
            sMap.put(sChars[rt], sMap.getOrDefault(sChars[rt], 0) + 1);
            if (sMap.equals(tMap)) {
                cnt++;
            }

            sMap.put(sChars[lt], sMap.get(sChars[lt]) - 1);
            if (sMap.get(sChars[lt]) <= 0) {
                sMap.remove(sChars[lt]);
            }
            lt++;
        }

        System.out.println(cnt + " ");
    }
}

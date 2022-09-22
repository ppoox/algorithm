package kimtaeone.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        solution(a, b);
    }

    private static void solution(String a, String b) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : a.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : b.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                System.out.println("NO");
                return;
            }
            map.put(c, map.get(c) - 1);
        }

        System.out.println("YES");
    }
}

package kimtaeone.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClassPresident {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String r = sc.next();

        solution(n, r);
    }

    private static void solution(int n, String r) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : r.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char p = '\0';
        int max = 0;
        for (char k : map.keySet()) {
            if (map.get(k) > max) {
                p = k;
                max = map.get(k);
            }
        }
        System.out.println(p);
    }

}

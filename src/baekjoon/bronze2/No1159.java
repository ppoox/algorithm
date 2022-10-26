package baekjoon.bronze2;

import java.util.*;

public class No1159 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Character> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> s : map.entrySet()) {
            if (s.getValue() >= 5) {
                pq.offer(s.getKey());
            }
        }

        if (pq.isEmpty()) {
            System.out.println("PREDAJA");
            return;
        }

        while (!pq.isEmpty()) {
            System.out.print(pq.poll());
        }
    }
}

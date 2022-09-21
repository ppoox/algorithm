package kimtaeone.twopointer;

import java.util.*;

public class CommonElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ns = new int[n];
        for (int i=0; i<n; i++) {
            ns[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] ms = new int[m];
        for (int i = 0; i < m; i++) {
            ms[i] = sc.nextInt();
        }

        solution(ns, ms);
    }

    private static void solution(int[] a, int[] b) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int n : a) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        for (int n : b) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) > 1) {
                System.out.print(i + " ");
            }
        }
    }
}

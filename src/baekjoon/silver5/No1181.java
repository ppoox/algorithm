package baekjoon.silver5;

import java.util.Arrays;
import java.util.Scanner;

public class No1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = sc.next();
        }

        Arrays.stream(strs).distinct().sorted((o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            } else {
                return o1.compareTo(o2);
            }
        }).forEach(System.out::println);

        sc.close();
    }
}

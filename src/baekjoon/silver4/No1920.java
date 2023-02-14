package baekjoon.silver4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class No1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> set = new HashSet<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        StringBuilder sb = new StringBuilder();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int size = set.size();
            set.add(sc.nextInt());
            if (size == set.size()) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

package baekjoon.silver4;

import java.util.Scanner;

public class No10816 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sangCards = new int[20000002];
        for (int i = 0; i < n; i++) {
            sangCards[sc.nextInt() + 10000000]++;
        }

        StringBuilder sb = new StringBuilder();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            sb.append(sangCards[sc.nextInt() + 10000000]).append(' ');
        }

        System.out.println(sb);
    }
}

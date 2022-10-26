package baekjoon.glod5;

import java.util.Arrays;
import java.util.Scanner;

public class No12865 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] packages = new int[N][2];
        for (int i = 0; i < N; i++) {
            packages[i][0] = sc.nextInt();
            packages[i][1] = sc.nextInt();
        }

        int[] dy = new int[K + 1];

        for (int i = 0; i < N; i++) {
            for (int j = K; j >= packages[i][0]; j--) {
                dy[j] = Math.max(dy[j - packages[i][0]] + packages[i][1], dy[j]);
            }
        }

        System.out.println(dy[K]);
    }
}

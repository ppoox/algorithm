package baekjoon.silver3;

import java.util.Arrays;
import java.util.Scanner;

public class No14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] cs = new int[N][2];

        for (int i = 0; i < N; i++) {
            cs[i][0] = sc.nextInt();
            cs[i][1] = sc.nextInt();
        }

        int[] dp = new int[N + 1];
        for (int i = 0; i < N; i++) {
            if (i + cs[i][0] <= N) {
                dp[i + cs[i][0]] = Math.max(dp[i + cs[i][0]], dp[i] + cs[i][1]);
            }

            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }


        System.out.println(dp[N]);
    }

}

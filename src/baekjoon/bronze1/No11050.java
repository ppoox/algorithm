package baekjoon.bronze1;

import java.util.Arrays;
import java.util.Scanner;

public class No11050 {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        dp = new int[n + 1][k + 1];

        System.out.println(binomial2(n, k));

        for (int[] d : dp) {
            System.out.println(Arrays.toString(d));
        }
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static int binomial1(int n, int k) {
        if (k == 0 || n == k) {
            return 1;
        }
        return binomial1(n - 1, k - 1) + binomial1(n - 1, k);
    }

    static int binomial2(int n, int k) {
        for (int i = 0; i <= n; i++) {
            // 0 ~ i 또는 0 ~ k 까지 중 작은 것을 택함 불필요한 것을 구하지 않기 위해서
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        return dp[n][k];
    }
}

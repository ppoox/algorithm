package kimtaeone.dynamic.knapsack;

import java.util.Scanner;

public class ExchangeCoin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        solution(coins, m);
    }

    private static void solution(int[] coins, int m) {
        int n = coins.length;
        int[] exchange = new int[m + 1];

        for (int i = 1; i <= m; i++) {
            exchange[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= m; j++) {
                exchange[j] = Math.min(exchange[j], exchange[j - coins[i]] + 1);
            }
        }

        System.out.println(exchange[m]);
    }
}

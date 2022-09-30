package kimtaeone.dfs;

import java.util.Arrays;
import java.util.Collections;
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
        solution(Arrays.stream(coins).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray(), m);
    }

    private static void solution(int[] coins, int m) {
        System.out.println(DFS(coins, m, 0, 0, 0));
    }

    private static int DFS(int[] coins, int m, int d, int cnt, int sum) {
        int n = coins.length;
        if (sum > m) {
            return Integer.MAX_VALUE;
        }
        if (d >= n) {
            return cnt;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, DFS(coins, m, d + 1, cnt + 1, sum + coins[i]));
        }
        return min;
    }
}

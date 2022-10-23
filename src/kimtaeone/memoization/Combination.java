package kimtaeone.memoization;

import java.util.Scanner;

public class Combination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int[][] memo = new int[n][n];
        System.out.println(solution(n, r, memo));
    }

    private static int solution(int n, int r, int[][] memo) {
        return DFS(n, r, memo);
    }

    private static int DFS(int n, int r, int[][] memo) {
        if (r == 1) {
            return n;
        }
        if (n == r) {
            return 1;
        }
        if (memo[n-1][r-1] != 0) {
            return memo[n-1][r-1];
        }

        return memo[n - 1][r - 1] = DFS(n - 1, r - 1, memo) + DFS(n - 1, r, memo);
    }
}

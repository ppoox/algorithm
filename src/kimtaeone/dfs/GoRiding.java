package kimtaeone.dfs;

import java.util.Scanner;

public class GoRiding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int n = sc.nextInt();
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        solution(c, weights);
    }

    private static void solution(int c, int[] weights) {
        System.out.println(DFS(0, 0, c, weights));
    }

    private static int DFS(int d, int sum, int c, int[] weights) {
        if (sum > c) {
            return 0;
        } else if (d >= weights.length) {
            return sum;
        }

        return Math.max(DFS(d + 1, sum + weights[d], c, weights), DFS(d + 1, sum, c, weights));
    }
}

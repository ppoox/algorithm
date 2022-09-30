package kimtaeone.dfs;

import java.util.Scanner;

public class MaxScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] problems = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                problems[i][j] = sc.nextInt();
            }
        }

        solution(m, problems);
    }

    private static void solution(int m, int[][] problems) {
        System.out.println(DFS(0, 0, 0, m, problems));
    }

    private static int DFS(int d, int score, int time, int m, int[][] problems) {
        if (time > m) {
            return 0;
        }
        if (d >= problems.length) {
            return score;
        }

        return Math.max(DFS(d + 1, score + problems[d][0], time + problems[d][1], m, problems), DFS(d + 1, score, time, m, problems));
    }
}

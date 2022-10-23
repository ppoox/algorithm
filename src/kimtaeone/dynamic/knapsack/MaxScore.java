package kimtaeone.dynamic.knapsack;

import java.util.Scanner;

public class MaxScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalProblem = sc.nextInt();
        int timeLimit = sc.nextInt();

        int[][] scores = new int[totalProblem][2];
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < 2; j++) {
                scores[i][j] = sc.nextInt();
            }
        }

        solution(scores, timeLimit);
    }

    private static void solution(int[][] scores, int timeLimit) {
        int[] dy = new int[timeLimit + 1];

        for (int[] score : scores) {
            for (int j = timeLimit; j >= score[1]; j--) {
                dy[j] = Math.max(dy[j], dy[j - score[1]] + score[0]);
            }
        }

        System.out.println(dy[timeLimit]);
    }
}

package _00_programers;

import java.util.Arrays;

public class IntegerTriangle {
    public static void main(String[] args) {
        int[][] triangle = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println(solution(triangle));
    }

    public static int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 1; j < triangle[i].length; j++) {
                int prev = dp[i - 1][j - 1];
                dp[i][j - 1] = Math.max(dp[i][j - 1], prev + triangle[i][j - 1]);
                dp[i][j] = Math.max(dp[i][j], prev + triangle[i][j]);

                System.out.println(i + " / " + j);
                for (int[] d : dp) {
                    System.out.println(Arrays.toString(d));
                }
                System.out.println();
            }
        }

        int max = 0;
        for (int last : dp[dp.length - 1]) {
            max = Math.max(max, last);
        }

        return max;
    }

}

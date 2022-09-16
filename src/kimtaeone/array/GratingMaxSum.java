package kimtaeone.array;

import java.util.Scanner;

public class GratingMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        solution(nums);
    }

    private static void solution(int[][] nums) {
        int max = 0;
        int n = nums.length;
        int diagPlusMax = 0;
        int diagMinusMax = 0;
        for (int i = 0; i < n; i++) {
            diagPlusMax += nums[i][i];
            diagMinusMax += nums[n-i-1][n-i-1];
            int colMax = 0;
            int rowMax = 0;
            for (int j = 0; j < n; j++) {
                colMax += nums[i][j];
                rowMax += nums[j][i];
            }
            max = Math.max(max, colMax);
            max = Math.max(max, rowMax);
        }

        max = Math.max(max, diagPlusMax);
        max = Math.max(max, diagMinusMax);

        System.out.println(max);
    }
}

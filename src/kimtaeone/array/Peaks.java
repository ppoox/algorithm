package kimtaeone.array;

import java.util.Scanner;

public class Peaks {
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
        int n = nums.length;
        int peakCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isPeak(nums, j, i)) {
                    peakCnt++;
                }
            }
        }

        System.out.println(peakCnt);
    }

    private static boolean isPeak(int[][] nums, int x, int y) {
        int n = nums.length;
        int p = nums[x][y];
        if (x - 1 >= 0 && nums[x - 1][y] >= p) {
            return false;
        } else if (y - 1 >= 0 && nums[x][y - 1] >= p) {
            return false;
        } else if (x + 1 < n && nums[x + 1][y] >= p) {
            return false;
        } else if (y + 1 < n && nums[x][y + 1] >= p) {
            return false;
        }
        return true;
    }
}

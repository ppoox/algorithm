package kimtaeone.array;

import java.util.Scanner;

public class CalculateScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        solution(nums);
    }

    private static void solution(int[] nums) {
        int acc = 0;
        int score = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                score += ++acc;
                continue;
            }
            acc = 0;
        }

        System.out.println(score);
    }
}

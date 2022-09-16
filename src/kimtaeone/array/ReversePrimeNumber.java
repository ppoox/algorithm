package kimtaeone.array;

import java.util.Scanner;

public class ReversePrimeNumber {
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
        for (int i = 0; i < nums.length; i++) {
            int origin = nums[i];
            int reverse = 0;
            while (origin > 0) {
                reverse = (reverse * 10) + (origin % 10);
                origin /= 10;
            }
            nums[i] = reverse;
        }

        outer:
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                continue;
            }

            int sqrt = (int) Math.sqrt(nums[i]);
            for (int j = 2; j < sqrt+1; j++) {
                if (nums[i] % j == 0) {
                    continue outer;
                }
            }

            System.out.print(nums[i] + " ");
        }

    }
}

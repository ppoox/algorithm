package kimtaeone.array;

import java.util.Scanner;

public class PrintBigNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(solution(nums));
    }

    public static String solution(int[] nums) {
        String answer = "";
        int prev = nums[0];
        answer += prev;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > prev) {
                answer += " " + nums[i];
            }

            prev = nums[i];
        }

        return answer;
    }
}

package kimtaeone.array;

import java.util.Scanner;

public class WatchStudent {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(solution(nums));
    }

    private static int solution(int[] nums) {
        int max = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                cnt++;
                max = nums[i];
            }
        }

        return cnt;
    }
}

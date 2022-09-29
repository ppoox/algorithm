package kimtaeone.search;

import java.util.Arrays;
import java.util.Scanner;

public class Stable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        solution(nums, m);
    }


    private static void solution(int[] nums, int m) {
        /**
         * 이분탐색 하는 기준을 잘 생각하자!
         * 여기서는 최대거리를 기준으로 이분탐색 실시
         */
        int answer = 0;
        Arrays.sort(nums);
        int lt = 1;
        int rt = nums[nums.length - 1];
        while (lt <= rt) {
            int mid = (rt + lt) / 2;
            if (count(nums, mid) >= m) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(answer);

    }

    private static int count(int[] nums, int mid) {
        int cnt = 1;
        int ep = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (ep + mid <= nums[i]) {
                ep = nums[i];
                cnt++;
            }
        }
        return cnt;
    }
}

package kimtaeone.search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
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
        int n = nums.length;
        int lt = 0;
        int rt = n;
        int answer = -1;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i <= n / 2; i++) {
            int mid = (lt + rt) / 2;
            if (m == nums[mid]) {
                answer = mid + 1;
                break;
            } else if (m > nums[mid]) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
            System.out.println(mid + " " + lt + " " + rt);
        }

        System.out.println(answer);
    }
}

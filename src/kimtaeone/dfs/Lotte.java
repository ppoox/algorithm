package kimtaeone.dfs;

import java.util.Arrays;

public class Lotte {

    public static void main(String[] args) {
        solution(9, 3);
        System.out.println("--------------------");
        solution(9, 2);
        System.out.println("--------------------");
        solution(9, 4);
    }

    private static void solution(int n, int k) {
        int[] checks = new int[n + 1];
        int[] nums = new int[k];
        DFS(n, checks, nums, k, 0);
    }

    private static void DFS(int n, int[] checks, int[] nums, int k, int d) {
        int sum = Arrays.stream(nums).sum();
        if (k == d) {
            if (sum == n) {
                for (int i = 0; i < nums.length - 1; i++) {
                    if (nums[i] <= nums[i+1]) {
                        return;
                    }
                }
                System.out.println(Arrays.toString(nums));
            }
            return;
        }
        if (sum > n) {
            return;
        }

        for (int i = checks.length - 1; i >= 0; i--) {
            if (checks[i] == 0) {
                checks[i] = 1;
                nums[d] = i;
                DFS(n, checks, nums, k, d + 1);
                checks[i] = 0;
            }
        }
    }
}

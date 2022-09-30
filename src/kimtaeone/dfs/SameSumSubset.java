package kimtaeone.dfs;

import java.util.*;

public class SameSumSubset {
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
        int[] checks = new int[nums.length];
        int d = 0;

        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(dfs(nums, checks, d, map) ? "YES" : "NO");
    }

    private static boolean dfs(int[] nums, int[] checks, int d, Map<Integer, Integer> map) {
        if (d >= nums.length) {
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < checks.length; i++) {
                if (checks[i] == 1) {
                    sum1 += nums[i];
                } else {
                    sum2 += nums[i];
                }
            }
            return sum1 == sum2;
        } else {
            checks[d] = 1;
            boolean dfs1 = dfs(nums, checks, d+1, map);
            checks[d] = 0;
            boolean dfs2 = dfs(nums, checks, d+1, map);

            return dfs1 || dfs2;
        }
    }
}

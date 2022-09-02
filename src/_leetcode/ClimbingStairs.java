package _leetcode;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(2)); // 1, 2
        System.out.println(climbStairs(3)); // 1, (1,2), (2,1)
        System.out.println(climbStairs(4)); // 1, (2,2), (1,1,2), (2,1,1), (1,2,1)
        System.out.println(climbStairs(5)); // 1, (2,2,1), (2,1,1,1), (1,1,2,1), (1,2,2)
        System.out.println(climbStairs(6)); // 1, (2,2,2), (2,2,1,1), (2,1,1,2), (1,1,2,2), (1,1,1,1,2), (2,1,1,1,1), (1,1,2,1,1)
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

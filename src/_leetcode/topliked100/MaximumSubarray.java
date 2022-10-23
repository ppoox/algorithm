package _leetcode.topliked100;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {1};
        int[] nums3 = {5,4,-1,7,8};
        int[] nums4 = {-2, 1};

        new MaximumSubarray().maxSubArray(nums);
//        new MaximumSubarray().maxSubArray(nums2);
//        new MaximumSubarray().maxSubArray(nums3);
//        new MaximumSubarray().maxSubArray(nums4);
    }

    public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = Math.max(A[i] + dp[i - 1] , A[i]);
            System.out.println(dp[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}

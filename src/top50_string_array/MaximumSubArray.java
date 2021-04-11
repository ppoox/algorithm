package top50_string_array;

public class MaximumSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int newSum = nums[0];
        int max = nums[0];

        for(int num : nums) {
            newSum = Math.max(num, newSum + num);
            max = Math.max(newSum, max);
        }

        return max;
    }
}

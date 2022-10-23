package leetcode;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        new SquaresOfSortedArray().sortedSquares(nums);
    }

    public int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        return nums;
    }
}

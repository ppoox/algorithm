package baekjoon;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {5, 6, 3, 8, 1, 2, 7, 4};
        sort(nums, 0, nums.length);

        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums, int left, int right) {
        if (right - left < 2) {
            return;
        }

        int mid = (left + right) / 2;
        sort(nums, 0, mid);
        sort(nums, mid, right);
        merge(nums, mid, left, right);
    }

    public static void merge(int[] nums, int mid, int left, int right) {
        int[] sorted = new int[right - left];
        int t = 0, l = left, r = mid;
        while (l < mid && r < right) {
            if (nums[l] < nums[r]) {
                sorted[t++] = nums[l++];
            } else {
                sorted[t++] = nums[r++];
            }
        }
        while (l < mid) {
            sorted[t++] = nums[l++];
        }
        while (r < right) {
            sorted[t++] = nums[r++];
        }
        for (int i = left; i < right; i++) {
            nums[i] = sorted[i - left];
        }
    }

}

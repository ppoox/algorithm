package _leetcode;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
//        int m = 1;
//        int n = 0;
//        int[] nums1 = {1};
//        int[] nums2 = {};
//
//        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int idx1 = 0, idx2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (idx1 < m && idx2 < n) {
                result[i] = nums1[idx1] <= nums2[idx2] ? nums1[idx1++] : nums2[idx2++];
                continue;
            }
            if (idx1 < m && idx2 >= n) {
                result[i] = nums1[idx1++];
                continue;
            }
            if (idx1 >= m && idx2 < n) {
                result[i] = nums2[idx2++];
                continue;
            }
        }
        for (int i = 0; i < result.length; i++) {
            nums1[i] = result[i];
        }
    }
}

package top50_string_array;

import java.util.Arrays;

/*
 * Time Complexity: O(n)
 * 데이타  int[] nums = {0,3, 2, 0, 8, 5};
 * 를 for문으로 모두 순회해야되니까
 * Space Complexity : O(1).
 * 주어진 문제에서 int currentIndex = 0;
 * 상수는 하나만 사용했으니까
 */
public class MoveZeros {

    public static void main(String args[]) {

        int[] nums = {0,3, 2, 0, 8, 5};
        int index = 0;

        for (int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }

        System.out.println(Arrays.toString(nums));

    }
}


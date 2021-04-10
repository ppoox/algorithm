package leetcode;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
//        System.out.println(Arrays.toString(twoSum(new int[]{2,3,4}, 6)));
//        System.out.println(Arrays.toString(twoSum(new int[]{-1,0}, -1)));
//        System.out.println(Arrays.toString(twoSum(new int[]{0,0,3,4}, 0)));
    }

    public static int[] twoSum(int[] numbers, int target) {

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                System.out.println("c");
                if(numbers[i] + numbers[j] == target) {
                    return new int[]{i+1, j+1};
                }

            }
        }
//        int start = 0, end = numbers.length - 1;
//        while(start < end){
//            System.out.println("c");
//            if(numbers[start] + numbers[end] == target) break;
//            if(numbers[start] + numbers[end] < target) start++;
//            else end--;
//        }
//        return new int[]{start + 1, end + 1};
        return null;

    }
}

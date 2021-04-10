package top50_string_array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
//        int[] nums = {2,8,11,21};
//        int target =10;
        int[] nums = {2,8,11,14};
        int target = 16;
        TwoSum a = new TwoSum();
        int[]  result = a.solve(nums, target);
        for(int i : result)
            System.out.println(i);
    }

    public int[] solve(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            Integer index = map.get(nums[i]);
            if(index != null) {
                result[0] = index;
                result[1] = i;

                break;
            }

            map.put(target - nums[i], i);
        }

        return result;
    }
}

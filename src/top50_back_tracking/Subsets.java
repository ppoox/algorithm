package top50_back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        new Subsets().subsets(input);
    }

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        subset(result, list, nums, 0);

        for (List<Integer> l : result) {
            System.out.println(Arrays.toString(l.toArray()));
        }


        return result;
    }

    public void subset(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
        result.add(new ArrayList<>(list));

        if (list.size() >= nums.length) {
            return;
        }

        for (int i=start; i<nums.length; i++) {
//
            list.add(nums[i]);
            subset(result, list, nums, i+1);
            list.remove(list.size() - 1);
        }
    }
}

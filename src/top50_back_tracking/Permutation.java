package top50_back_tracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(solve(nums));
    }

    public static List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        dfs(nums, result, list);

        return result;
    }

    private static void dfs(int[] nums, List<List<Integer>> lists, List<Integer> cur) {
        if (cur.size() == nums.length) {
            List<Integer> list = new ArrayList<>(cur);
            lists.add(list);
        }

        for (int i = 0; i < nums.length; i++) {
//            if(cur.size() == nums.length) {
//                continue;
//            }

            if (cur.contains(nums[i])) {
                continue;
            }

            System.out.println(nums[i]);
            cur.add(nums[i]);
            dfs(nums, lists, cur);
            cur.remove(cur.size()-1);
        }
    }
}

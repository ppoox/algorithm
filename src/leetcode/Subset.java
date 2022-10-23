package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

//    Input: nums = [1,2,2]
//    Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

    public static void main(String[] args) {
        for (List<Integer> l : solution(new int[]{1, 2, 2})) {
            System.out.println(Arrays.toString(l.toArray()));
        }
        ;
    }

    public static List<List<Integer>> solution(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        recursive(result, new ArrayList<>(), nums, 0);

        return result;
    }

    public static void recursive(List<List<Integer>> rs, List<Integer> ls, int[] nums, int pos) {
        rs.add(new ArrayList<>(ls));
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) continue;
            ls.add(nums[i]);
            recursive(rs, ls, nums, i + 1);
            ls.remove(ls.size() - 1);
        }
    }
}

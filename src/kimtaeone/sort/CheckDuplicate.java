package kimtaeone.sort;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CheckDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        solution(nums);
    }

    private static void solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        System.out.println(set.size() == nums.length ? "U" : "D");
    }
}

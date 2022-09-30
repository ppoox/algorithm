package kimtaeone.dfs;

import java.util.Arrays;

public class PermutationWithRepetition {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        int n = 3;
        int c = 2;
        int[] nums = new int[n];
        int[] pm = new int[c];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }


        DFS(0, nums, pm, c);
    }

    private static void DFS(int d, int[] nums, int[] pm, int c) {
        if (d >= pm.length) {
            System.out.println(Arrays.toString(pm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            pm[d] = nums[i];
            DFS(d+1, nums, pm, c);
        }
    }
}

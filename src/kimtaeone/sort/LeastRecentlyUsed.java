package kimtaeone.sort;

import java.util.Scanner;

public class LeastRecentlyUsed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        solution(s, nums);
    }

    private static void solution(int s, int[] nums) {
        int[] cache = new int[s];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int cacheIdx = -1;
            for (int j = 0; j < s; j++) {
                if (cache[j] == 0 || nums[i] == cache[j]) {
                    cache[j] = 0;
                    cacheIdx = j;
                    break;
                }
            }

            if (cacheIdx == -1) {
                cacheIdx = s - 1;
            }

            for (int j = cacheIdx; j > 0; j--) {
                cache[j] = cache[j - 1];
            }

            cache[0] = nums[i];
        }

        for (int v : cache) {
            System.out.print(v + " ");
        }
    }
}

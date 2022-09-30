package kimtaeone.dfs;

import java.util.Scanner;

public class Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        solution(nums, r);
    }

    static int[] checks;
    static int[] pm;

    private static void solution(int[] nums, int r) {
        checks = new int[nums.length];
        pm = new int[r];
        DFS(nums, r, 0);

    }

    private static void DFS(int[] nums, int r, int d) {
        if (d == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(pm[i] + " ");
            }
//            for (int i = 0; i < checks.length; i++) {
//                if (checks[i] == 1) {
//                    System.out.print(nums[i] + " ");
//                }
//            }
            System.out.println();
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (checks[i] == 0) {
                checks[i] = 1;
                /**
                 * pm 배열을 사용하지 않으면 순서 유지가 불가
                 */
                pm[d] = nums[i];
                DFS(nums, r, d + 1);
                checks[i] = 0;
            }
        }
    }
}

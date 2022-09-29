package kimtaeone.search;

import java.util.Arrays;
import java.util.Scanner;

public class MusicVideo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        solution(nums, m);
    }

    private static void solution(int[] nums, int m) {
        int i = Arrays.stream(nums).max().orElse(0);
    }
}

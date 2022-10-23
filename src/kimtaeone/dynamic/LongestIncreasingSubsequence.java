package kimtaeone.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sequences = new int[n];
        for (int i = 0; i < n; i++) {
            sequences[i] = sc.nextInt();
        }
        solution(sequences);
    }

    private static void solution(int[] sequences) {

        int[] memo = new int[sequences.length];
        memo[0] = 1;
        for (int i = 1; i < memo.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (sequences[i] > sequences[j]) {
                    memo[i] = Math.max(memo[i], memo[j]);
                }
            }
            memo[i] += 1;
        }

        System.out.println(Arrays.stream(memo).max().getAsInt());
    }
}

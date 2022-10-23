package baekjoon.silver3;

import java.util.Scanner;

public class No2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int[] stairs = new int[S];
        for (int i = 0; i < stairs.length; i++) {
            stairs[i] = sc.nextInt();
        }

        int[] dp = new int[S];

        if (S == 1) {
            System.out.println(stairs[0]);
            return;
        } else if (S == 2) {
            System.out.println(stairs[0] + stairs[1]);
            return;
        }

        dp[0] = stairs[0];
        dp[1] = stairs[0] + stairs[1];
        dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);

        for (int i = 3; i < S; i++) {
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
        }

        System.out.println(dp[S - 1]);
    }
}

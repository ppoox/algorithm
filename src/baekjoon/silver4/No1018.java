package baekjoon.silver4;

import java.util.Scanner;

public class No1018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, check(board, i, j));
            }
        }

        System.out.println(min);
        sc.close();
    }

    public static int check(char[][] board, int y, int x) {
        String[] collects = {"WBWBWBWB", "BWBWBWBW"};
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int row = y + i;
            for (int j = 0; j < 8; j++) {
                int col = x + j;
                if (board[row][col] != collects[row % 2].charAt(j)) {
                    cnt++;
                }
            }
        }

        return Math.min(cnt, 64 - cnt);
    }
}

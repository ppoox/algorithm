package kimtaeone.stack;

import java.util.Scanner;
import java.util.Stack;

public class ClawCraneGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = sc.nextInt();
        }

        solution(board, moves);
    }

    private static void solution(int[][] board, int[] moves) {
        int n = board.length;
        int m = moves.length;
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = board[j][moves[i] - 1];
                if (v != 0) {
                    if (!stack.isEmpty() && stack.peek() == v) {
                        stack.pop();
                        cnt += 2;
                    } else {
                        stack.push(v);
                    }
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}

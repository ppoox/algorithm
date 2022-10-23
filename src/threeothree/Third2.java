package threeothree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Third2 {
    public static void main(String[] args) {
        String[] board1 = {"EEEEE", "EEMEE", "EEEEE", "EEEEE"};
        new Third2().solution(board1, 2, 0);
    }

    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public String[] solution(String[] board, int y, int x) {
        String[] answer = {};
        int n = board.length;
        int m = board[0].length();
        char[][] mineBoard = new char[n][m];
        int idx = 0;
        for (String b : board) {
            mineBoard[idx] = b.toCharArray();
//            System.out.println(Arrays.toString(mineBord[i]));
            idx++;
        }



        Queue<Integer> queue = new LinkedList<>();
        explore(mineBoard, y, x, queue);

        System.out.println();
        for (char[] b : mineBoard) {
            System.out.println(Arrays.toString(b));
        }
        return answer;
    }

    public void explore(char[][] board, int y, int x, Queue<Integer> queue) {
        int n = board.length;
        int m = board[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return;
        }
        for (int k = 0; k < 8; k++) {
            queue.add(k);
        }

    }

}

package threeothree;

import java.util.Arrays;

public class Third {
    public static void main(String[] args) {
        String[] board1 = {"EEEEE", "EEMEE", "EEEEE", "EEEEE"};
        new Third().solution(board1, 2, 0);
    }

    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    public String[] solution(String[] board, int y, int x) {
        String[] answer = {};
        int n = board.length;
        int m = board[0].length();
        char[][] mineBoard = new char[n][m];
        int i = 0;
        for (String b : board) {
            mineBoard[i] = b.toCharArray();
//            System.out.println(Arrays.toString(mineBord[i]));
            i++;
        }

        dfs(mineBoard, y, x);
        System.out.println();
        for (char[] b : mineBoard) {
            System.out.println(Arrays.toString(b));
        }
        return answer;
    }

    public char dfs(char[][] mineBoard, int y, int x) {
        int n = mineBoard.length;
        int m = mineBoard[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n || mineBoard[y][x] == 'B' || mineBoard[y][x] == 'M' || Character.isDigit(mineBoard[y][x])) {
            return 'N';
        }


        if (mineBoard[y][x] == 'E') {
            mineBoard[y][x] = 'B';
            int mineCnt = 0;
            for (int i = 0; i < 8; i++) {
                char value = dfs(mineBoard, y + dy[i], x + dx[i]);
                if (value == 'M') {
                    mineBoard[y][x] = Character.forDigit(Character.digit(mineBoard[y][x], 10) + 1, 10);
//                    mineCnt++;
                    break;
                }

            }

//            if (mineCnt > 0) {
//                mineBoard[y][x] = Character.forDigit(mineCnt, 10);
//            } else {
//
//            }
        }

        for (char[] b : mineBoard) {
            System.out.println(Arrays.toString(b));
        }
        System.out.println();

        return mineBoard[y][x];
    }

}

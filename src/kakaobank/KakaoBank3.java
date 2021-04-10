package kakaobank;

import java.util.Arrays;

public class KakaoBank3 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2, 4, 8, 2}, {2, 2, 2, 2}, {0, 4, 2, 4}, {2, 2, 2, 4}}));
    }

    public static int solution(int[][] board) {
        int answer = -1;

        for(int i=0; i<4; i++) {
            board = up(board, i);
        }

        // print
        for(int i=0; i<board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }

        return answer;
    }

    public static int[][] up(int[][] board, int i) {
        for(int x=0; x<4; x++) {
            for(int j=0; j<4; j++) {
                if(j+1 == 4) {
                    break;
                }
                if(board[j][i] == board[j+1][i]) {
                    board[j][i] = board[j][i] + board[j+1][i];
                    board[j+1][i] = 0;
                }
            }
            for(int k=0; k<4; k++) {
                if(k+1 == 4) {
                    break;
                }
                if(board[k][i] == 0) {
                    board[k][i] = board[k+1][i];
                    board[k+1][i] = 0;
                }
            }

        }

        return board;
    }
}

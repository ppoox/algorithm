package baekjoon.bronze1;

import java.util.Scanner;

public class No1236 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] walls = new String[N];

        for (int i = 0; i < N; i++) {
            walls[i] = sc.next();
        }

        int rowCnt = 0;
        for (String wall : walls) {
            if (!wall.contains("X")) {
                rowCnt++;
            }
        }

        int colCnt = 0;
        rootLoop:
        for (int i = 0; i < M; i++) {
            for (String wall : walls) {
                if (wall.charAt(i) == 'X') {
                    continue rootLoop;
                }
            }
            colCnt++;
        }

        System.out.println(Math.max(rowCnt, colCnt));
    }
}

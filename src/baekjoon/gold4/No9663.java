package baekjoon.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9663 {

    static int n, count;
    static int[] col;

    public static void main(String[] args) throws IOException {
        input();
        recursive(1);
        System.out.println(count);
    }

    private static void recursive(int row) {
        if (row == n + 1) {
            count++;
        } else {
            for (int c = 1; c <= n; c++) {
                boolean possible = true;
                for (int i = 1; i <= row - 1; i++) {
                    if (attackable(row, c, i, col[i])) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    col[row] = c;
                    recursive(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

    private static boolean attackable(int r1, int c1, int r2, int c2) {
        if (r1 == r2 || c1 == c2) return true;
        if (r1 + c1 == r2 + c2) return true;
        if (r1 - c1 == r2 - c2) return true;
        return false;
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        col = new int[n + 1];
        count = 0;
        br.close();
    }
}

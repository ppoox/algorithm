package baekjoon.glod5;

import java.util.Arrays;
import java.util.Scanner;

public class No14503 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int y = sc.nextInt();
        int x = sc.nextInt();
        int d = sc.nextInt();

        int[][] map = new int[N][M];
        int temp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 0) {
                    temp++;
                }
            }
        }
        System.out.println("temp: " + temp);

        int result = DFS(map, x, y, d, 0);

        for (int[] m : map) {
            System.out.println(Arrays.toString(m));
        }
        System.out.println("==========================");

        System.out.println(result);
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] dir = {3, 2, 1, 0};

    public static int DFS(int[][] map, int x, int y, int d, int cnt) {
        if (x < 0 || y < 0 || x >= map[0].length || y >= map.length || map[y][x] != 0) {
            return cnt;
        }

        map[y][x] = 1;
        int max = cnt;

        for (int i = d; i < d + 4; i++) {
            int nd = i > 3 ? i - 4 : i;
            int nx = x + dx[nd];
            int ny = y + dy[nd];
            max = Math.max(max, DFS(map, nx, ny, nd, cnt + 1));
        }

        return max;
    }
}

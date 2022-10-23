package kimtaeone.dfs;

import java.util.Scanner;

public class Island {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] maps = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maps[i][j] = sc.nextInt();
            }
        }

        solution(maps);
    }

    private static void solution(int[][] maps) {
        int cnt = 0;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                cnt += DFS(maps, j, i, 0);
            }
        }

        System.out.println(cnt);
    }

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    private static int DFS(int[][] maps, int x, int y, int d) {
        int n = maps.length;
        if (x < 0 || y < 0 || x >= n || y >= n || maps[y][x] == 0) {
            return d;
        }

        maps[y][x] = 0;

        for (int i = 0; i < 8; i++) {
            DFS(maps, x + dx[i], y + dy[i], d + 1);
        }

        return d + 1;
    }
}

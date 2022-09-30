package kimtaeone.dfs;

import java.util.Scanner;

public class SearchMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] maze = new int[7][7];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        solution(maze);
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int cnt = 0;
    private static void solution(int[][] maze) {
        DFS(maze, 0, 0);

        System.out.println(cnt);
    }

    private static void DFS(int[][] maze, int x, int y) {
        if (x < 0 || y < 0 || y >= maze.length || x >= maze[y].length || maze[x][y] == 1) {
            return;
        }
        if (x == 6 && y == 6) {
            cnt++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            maze[x][y] = 1;
            DFS(maze, x + dx[i], y + dy[i]);
            maze[x][y] = 0;
        }
    }


}

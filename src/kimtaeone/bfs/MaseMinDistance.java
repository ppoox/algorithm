package kimtaeone.bfs;

import java.util.*;

public class MaseMinDistance {
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

    private static void solution(int[][] maze) {
        Queue<Map<String, Integer>> queue = new LinkedList<>();
        Map<String, Integer> smap = new HashMap<>();
        smap.put("x", 0);
        smap.put("y", 0);
        queue.offer(smap);

        int cnt = 0;
        int x = 0;
        int y = 0;

        int n = maze.length;
        outerWhile:
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Map<String, Integer> poll = queue.poll();
                x = poll.get("x");
                y = poll.get("y");

                if (x == 6 && y == 6) {
                    break outerWhile;
                }

                maze[x][y] = 1;

                for (int j = 0; j < 4; j++) {
                    int mx = x + dx[j];
                    int my = y + dy[j];

                    if (mx >= 0 && mx < n && my >= 0 && my < n && maze[mx][my] == 0) {
                        Map<String, Integer> map = new HashMap<>();
                        map.put("x", mx);
                        map.put("y", my);
                        queue.offer(map);
                    }
                }
            }

            cnt++;
        }

        if (x == 6 && y == 6) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }


}

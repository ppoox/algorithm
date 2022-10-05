package kimtaeone.bfs;

import java.util.*;

class Pointer {
    private int x;
    private int y;

    public Pointer(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class Tomato {
    static Queue<Pointer> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] box = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = sc.nextInt();
                if (box[i][j] == 1) {
                    queue.offer(new Pointer(j, i));
                }
            }
        }

        solution(m, n, box);
    }

    private static void solution(int x, int y, int[][] box) {
        boolean isAllRipe = true;
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[i].length; j++) {
                if (box[i][j] == 0) {
                    isAllRipe = false;
                    break;
                }
            }
        }

        if (isAllRipe) {
            System.out.println(0);
            return;
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[][] dis = new int[box.length][box[0].length];
        int nx, ny;
        while (!queue.isEmpty()) {
            Pointer poll = queue.poll();
            nx = poll.getX();
            ny = poll.getY();

            for (int j = 0; j < 4; j++) {
                int mx = nx + dx[j];
                int my = ny + dy[j];
                if (mx >= 0 && my >= 0 && mx < x && my < y && box[my][mx] == 0) {
                    box[my][mx] = 1;
                    queue.offer(new Pointer(mx, my));
                    dis[my][mx] = dis[ny][nx] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[i].length; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, dis[i][j]);
            }
        }

        System.out.println(max);
    }

}

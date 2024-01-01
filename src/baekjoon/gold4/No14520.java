package baekjoon.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No14520 {
    static int N, M, W;
    static int[][] lab;
    static boolean[][] visit;
    static int[][] wallPoint;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int area = 0;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];
        visit = new boolean[N][M];
        wallPoint = new int[N * M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();
    }

    static void solve() {
        calculateWallPoint();
        buildWalls(0, 0);
        System.out.println(area);
    }

    static void calculateWallPoint() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (lab[i][j] == 0) {
                    wallPoint[W][0] = i;
                    wallPoint[W][1] = j;
                    W++;
                }
            }
        }
    }

    static void buildWalls(int idx, int cnt) {
        // DFS로 벽을 세운다.

        // 벽이 3개가 되었을 경우 바이러스를 퍼트리기
        if (cnt == 3) {
            spreadVirus();
            countSafetyArea();
            return;
        }
        // 세울수 있는 벽이 넘어간 경우
        if (idx >= W) {
            return;
        }

        // 벽을 세우는 경우
        lab[wallPoint[idx][0]][wallPoint[idx][1]] = 1;
        buildWalls(idx + 1, cnt + 1);

        // 벽을 세우지 않은 경우
        lab[wallPoint[idx][0]][wallPoint[idx][1]] = 0;
        buildWalls(idx + 1, cnt);
    }

    static void spreadVirus() {
        // BFS로 바이러스를 퍼트린다.
        Queue<Integer> queue = new LinkedList<>();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                visit[y][x] = false;
                if (lab[y][x] == 2) {
                    queue.offer(x);
                    queue.offer(y);
                    visit[y][x] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            Integer y = queue.poll();
            for (int j = 0; j < 4; j++) {
                int nx = x + dir[j][0];
                int ny = y + dir[j][1];
                if (nx >= 0 && ny >= 0 && nx < M && ny < N && lab[ny][nx] == 0 && !visit[ny][nx]) {
                    visit[ny][nx] = true;
                    queue.offer(nx);
                    queue.offer(ny);
                }
            }
        }
    }

    static void countSafetyArea() {
        int cnt = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (lab[y][x] == 0 && !visit[y][x]) {
                    cnt++;
                }
            }
        }

        area = Math.max(area, cnt);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}

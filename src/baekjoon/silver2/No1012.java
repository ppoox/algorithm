package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1012 {
    static int T, M, N, K;
    static int[][] ground;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ground = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ground[y][x] = 1;
        }
    }

    static void solve() {
        int cnt = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (ground[y][x] == 1) {
                    cnt++;
                    dfs(x, y);
                }
            }
        }
        sb.append(cnt).append('\n');
    }

    static void dfs(int x, int y) {
        ground[y][x] = 0;
        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if (ground[ny][nx] == 0) continue;
            dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            input();
            solve();
        }

        System.out.println(sb);

        br.close();
    }
}

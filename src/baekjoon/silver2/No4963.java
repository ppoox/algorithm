package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No4963 {
    static int w, h;
    static int[][] map;
    static int[][] dir = {
            {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}
    };
    static StringBuilder sb = new StringBuilder();

    static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            map = new int[h][w];
            for (int y = 0; y < h; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < w; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (map[y][x] == 1) {
                        dfs(x, y);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append('\n');
        }

        br.close();
    }

    static void dfs(int x, int y) {
        map[y][x] = 0;

        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
            if (map[ny][nx] == 0) continue;

            dfs(nx, ny);
        }
    }

    public static void main(String[] args) throws IOException {
        solve();
        System.out.println(sb);
    }

}

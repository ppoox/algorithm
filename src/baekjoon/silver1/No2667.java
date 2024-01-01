package baekjoon.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No2667 {
    static int N;
    static int[][] map;
    static int[][] dir = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };
    static int complex;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        br.close();
    }

    static void solve() {
        StringBuilder sb = new StringBuilder();
        List<Integer> complexes = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    complex = 0;
                    cnt++;
                    dfs(j, i);
                    complexes.add(complex);
                }
            }
        }

        sb.append(cnt).append('\n');

        Collections.sort(complexes);
        for (int c : complexes) {
            sb.append(c).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        map[y][x] = 0;
        complex++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[ny][nx] == 1) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

}

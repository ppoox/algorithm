package baekjoon.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3184 {
    static int R, C, sheep = 0, wolf = 0;
    static char[][] ground;
    static int[][] dir = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ground = new char[R][C];

        for (int y = 0; y < R; y++) {
            ground[y] = br.readLine().toCharArray();
        }

        br.close();
    }

    static void solve() {
        int totalSheep = 0;
        int totalWolf = 0;

        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (ground[y][x] == 'v' || ground[y][x] == 'o') {
                    dfs(x, y);
                    if (sheep > wolf) {
                        totalSheep += sheep;
                    } else {
                        totalWolf += wolf;
                    }
                    sheep = 0;
                    wolf = 0;
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }

    static void dfs(int x, int y) {
        if (ground[y][x] == 'v') {
            wolf++;
        }
        if (ground[y][x] == 'o') {
            sheep++;
        }
        ground[y][x] = '@';
        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx < 0 || ny < 0 || nx >= C || ny >= R) continue;
            if (ground[ny][nx] == '@' || ground[ny][nx] == '#') continue;

            dfs(nx, ny);
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}

package baekjoon.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2606 {
    static int G, N;
    static int[][] graph;
    static boolean[] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        graph = new int[N][2];
        visit = new boolean[G + 1];

        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine()
                            .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        br.close();
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            if (graph[i][0] == 1) dfs(graph[i][1]);
        }

        int cnt = 0;
        for (boolean v : visit) {
            if (v) cnt++;
        }

        System.out.println(cnt > 0 ? cnt - 1 : 0);
    }

    static void dfs(int n) {
        if (visit[n]) return;

        visit[n] = true;

        for (int i = 0; i < N; i++) {
            if (graph[i][0] == n) dfs(graph[i][1]);
            if (graph[i][1] == n) dfs(graph[i][0]);
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}

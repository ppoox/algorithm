package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1260 {
    static int N, M, V;
    static int[][] graph;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();

        dfs(V);
        sb.append('\n');
        for (int i = 1; i <= N; i++) visit[i] = false;
        bfs(V);

        System.out.println(sb);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        br.close();
    }

    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(' ');
        for (int y = 1; y <= N; y++) {
            if (graph[x][y] == 0) continue;
            if (visit[y]) continue;
            dfs(y);
        }
    }

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visit[x] = true;
        while (!queue.isEmpty()) {
            x = queue.poll();
            sb.append(x).append(' ');

            for (int y = 1; y <= N; y++) {
                if (graph[x][y] == 0) continue;
                if (visit[y]) continue;
                queue.add(y);
                visit[y] = true;
            }
        }
    }
}

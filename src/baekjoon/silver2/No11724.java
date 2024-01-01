package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No11724 {
    static int N, M;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        br.close();
    }

    static void solve() {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                dfs(i, 1);
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    static void dfs(int index, int depth) {
        visit[index] = true;

        List<Integer> d = graph.get(index);
        for (int node : d) {
            if (visit[node]) continue;
            dfs(node, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}

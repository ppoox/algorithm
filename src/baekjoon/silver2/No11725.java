package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No11725 {
    static int N;
    static List<List<Integer>> linkedList = new ArrayList<>();
    static int[] parents;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            linkedList.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            int[] nodeInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            linkedList.get(nodeInfo[0]).add(nodeInfo[1]);
            linkedList.get(nodeInfo[1]).add(nodeInfo[0]);
        }

        br.close();
    }

    static void solve() {
        dfs(1, -1);
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int node, int parentNode) {
        for (int n : linkedList.get(node)) {
            if (n == parentNode) continue;
            parents[n] = node;
            dfs(n, node);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}

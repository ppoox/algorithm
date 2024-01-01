package baekjoon.glod5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class State {
    protected int[] bottles;

    public State(int[] bottles) {
//        this.bottles = Arrays.copyOf(bottles, 3);
        this.bottles = new int[bottles.length];
        for (int i = 0; i < bottles.length; i++) {
            this.bottles[i] = bottles[i];
        }
    }

    protected State move(int from, int to, int[] limit) {
        int[] copy = Arrays.copyOf(bottles, 3);
        if (copy[from] + copy[to] <= limit[to]) {
            copy[to] += copy[from];
            copy[from] = 0;
        } else {
            copy[from] -= limit[to] - copy[to];
            copy[to] = limit[to];
        }
        return new State(copy);
    }
}

public class No2251 {
    static int[] limit;
    static boolean[] possible;
    static boolean[][][] visit;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        limit = new int[3];
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    static void solve() {
        possible = new boolean[201];
        visit = new boolean[201][201][201];

        bfs(0, 0, limit[2]);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < possible.length; i++) {
            if (possible[i]) {
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }

    static void bfs(int a, int b, int c) {
        Queue<State> queue = new LinkedList<>();
        // 시작지점
        queue.add(new State(new int[]{a, b, c}));
        visit[a][b][c] = true;

        while (!queue.isEmpty()) {
            State state = queue.poll();
            // A가 비어있느냐?
            if (state.bottles[0] == 0) {
                possible[state.bottles[2]] = true;
            }
            // 모든 물통에 담기
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) {
                        continue;
                    }
                    State nextState = state.move(from, to, limit);

                    // nextState가 움직인적 있는지 판단하여 queue에 담는다.
                    if (!visit[nextState.bottles[0]][nextState.bottles[1]][nextState.bottles[2]]) {
                        visit[nextState.bottles[0]][nextState.bottles[1]][nextState.bottles[2]] = true;
                        queue.offer(nextState);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}

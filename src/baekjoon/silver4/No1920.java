package baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1920 {
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        M = Integer.parseInt(br.readLine());
        B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        br.close();
    }

    public static void solve() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int exist = binarySearch(B[i]);
            sb.append(exist).append("\n");
        }
        System.out.println(sb);
    }

    public static int binarySearch(int find) {
        int l = 0;
        int r = N - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (A[m] == find) {
                return 1;
            } else if (A[m] > find) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return 0;
    }
}

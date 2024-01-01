package baekjoon.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No7795 {
    static int T, N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        solve();
    }

    public static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split(" ");
            N = Integer.parseInt(split[0]);
            M = Integer.parseInt(split[1]);
            A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            sb.append(count()).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static int count() {
        Arrays.sort(B);
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i] > B[j]) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}

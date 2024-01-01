package baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1764 {
    static int N, M;
    static String[] A, B;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (String name : B) {
            if (binarySearch(name)) {
                count++;
                sb.append(name).append("\n");
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }

    private static boolean binarySearch(String name) {
        int l = 0;
        int r = N - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (name.equals(A[m])) {
                return true;
            } else if (A[m].compareTo(name) > 0) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }

        B = new String[M];
        for (int i = 0; i < M; i++) {
            B[i] = br.readLine();
        }

        br.close();
    }
}

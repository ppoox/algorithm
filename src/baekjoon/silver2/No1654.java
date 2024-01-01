package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1654 {
    static int K;
    static int N;
    static int[] lines;

    public static void main(String[] args) throws IOException {
        input();
        Arrays.sort(lines);
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        K = Integer.parseInt(splits[0]);
        N = Integer.parseInt(splits[1]);
        lines = new int[K];
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }
        br.close();
    }

    static void solve() {
        System.out.println(searchBinary());
    }

    static long searchBinary() {
        long left = 1;
        long right = lines[lines.length - 1];
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (available(mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    static boolean available(long max) {
        long sum = 0;
        for (int i = 0; i < K; i++) {
            sum += lines[i] / max;
        }
        return sum >= N;
    }
}

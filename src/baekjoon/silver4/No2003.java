package baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2003 {
    static int N;
    static int M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        N = Integer.parseInt(splits[0]);
        M = Integer.parseInt(splits[1]);
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
    }

    static void solve() {
        int right = 0;
        int sum = 0;
        int count = 0;

        for (int left = 0; left < N; left++) {
            while (right < N && sum + A[right] <= M) {
                sum += A[right++];
            }

            if (sum >= M) {
                count++;
            }
            sum -= A[left];
        }

        System.out.println(count);
    }
}

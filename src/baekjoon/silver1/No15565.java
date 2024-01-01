package baekjoon.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No15565 {
    static int N;
    static int K;
    static int[] dolls;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        N = Integer.parseInt(splits[0]);
        K = Integer.parseInt(splits[1]);
        dolls = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
    }

    static void solve() {
        int count = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        for (int left = 0; left < N; left++) {
            if (dolls[left] == 2) {
                continue;
            }
            while (right < N && count < K) {
                if (dolls[right++] == 1) {
                    count++;
                }
            }
            if (count == K) {
                minLength = Math.min(minLength, right - left);
            }
            count--;
        }

        System.out.println(minLength == Integer.MAX_VALUE ? -1 : minLength);
    }
}

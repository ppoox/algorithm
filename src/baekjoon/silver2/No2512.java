package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2512 {
    static int N, M;
    static int[] budget;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        budget = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = Integer.parseInt(br.readLine());
        br.close();
    }

    static void solve() {
        int sum = Arrays.stream(budget).sum();
        if (sum <= M) {
            System.out.println(Arrays.stream(budget).max().orElse(0));
            return;
        }

        searchLimit();
    }

    static void searchLimit() {
        int bottom = 0;
        int top = M;
        int sum = 0;
        int ans = 0;
        while (bottom <= top) {
            int middle = (top + bottom) / 2;

            sum = calculateSum(middle);
            if (sum <= M) {
                ans = middle;
                bottom = middle + 1;
            } else {
                top = middle - 1;
            }
        }

        System.out.println(ans);
    }

    static int calculateSum(int limit) {
        int sum = 0;
        for (int b : budget) {
            if (b > limit) {
                sum += limit;
            } else {
                sum += b;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}

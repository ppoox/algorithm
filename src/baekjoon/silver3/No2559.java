package baekjoon.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2559 {
    static int N;
    static int K;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] splits = br.readLine().split(" ");
        N = Integer.parseInt(splits[0]);
        K = Integer.parseInt(splits[1]);
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        br.close();
    }

    static void solve() {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int right = 0;
        int count = 0;
        for (int left = 0; left <= N - K; left++) {
            while (right < N && count < K) {
                sum += nums[right++];
                count++;
            }
            System.out.println("size: " + K + ", left: " + left + ", right: " + right + ", count: " + count + ", sum: " + sum);
            max = Math.max(max, sum);
            sum -= nums[left];
            count--;
        }
        System.out.println(max);
    }
}

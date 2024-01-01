package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1182 {
    static int N;
    static int S;
    static int[] numbers;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        input();
        solve(0, 0);
        if (S == 0) {
            answer--;
        }
        System.out.println(answer);
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NS = br.readLine().split(" ");
        N = Integer.parseInt(NS[0]);
        S = Integer.parseInt(NS[1]);
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
    }
    public static void solve(int d, int sum) {
        if (d >= N) {
            if (sum == S) {
                answer++;
            }
        } else {
            solve(d + 1, sum + numbers[d]);
            solve(d + 1, sum);
        }
    }
}

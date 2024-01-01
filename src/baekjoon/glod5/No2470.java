package baekjoon.glod5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2470 {
    static int N;
    static int[] solutions;
    static StringBuilder sb =  new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        solutions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        br.close();
    }

    public static void solve() {
        int sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        for (int i = 0; i < N - 1; i++) {
            int similarNumberIndex = binarySearch(i + 1, N, -solutions[i]);

            if (i < similarNumberIndex - 1) {
                int leftSum = Math.abs(solutions[i] + solutions[similarNumberIndex - 1]);
                if (leftSum < sum) {
                    sum = leftSum;
                    v1 = solutions[i];
                    v2 = solutions[similarNumberIndex - 1];
                }
            }
            if (similarNumberIndex < N) {
                int rightSum = Math.abs(solutions[i] + solutions[similarNumberIndex]);
                if (rightSum < sum) {
                    sum = rightSum;
                    v1 = solutions[i];
                    v2 = solutions[similarNumberIndex];
                }
            }
        }

        sb.append(v1).append(" ").append(v2);
        System.out.println(sb);
    }

    public static int binarySearch(int left, int right, int find) {
        int result = right;
        while (left < right) {
            int mid = (left + right) / 2;
            if (solutions[mid] >= find) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
//9
//-100 -90 0 90 130 130 130 130 130

//    5
//    -99 -2 -1 4 98

//5
//-100 -90 0 90 130


package baekjoon.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No3273 {
    static int N;
    static int[] A;
    static int X;
    static int count;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(count);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        X = Integer.parseInt(br.readLine());
        br.close();
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            searchBinary(X - A[i], i);
        }
    }

    static void searchBinary(int find, int index) {
        int left = index;
        int right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (A[mid] == find) {
                if (mid != index) {
                    count++;
                }
                break;
            } else if (A[mid] < find) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
}

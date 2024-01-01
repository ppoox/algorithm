package baekjoon.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class No11728 {
    static int N;
    static int M;
    static int[] A;
    static int[] B;

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
        B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
    }

    static void solve() {
        int aCursor = 0;
        int bCursor = 0;
        int[] merge = new int[N + M];
        int cursor = 0;
        while (aCursor < N && bCursor < M) {
            if (A[aCursor] <= B[bCursor]) {
                merge[cursor++] = A[aCursor++];
            } else {
                merge[cursor++] = B[bCursor++];
            }
        }
        for (int i = aCursor; i < N; i++) {
            merge[cursor++] = A[i];
        }
        for (int i = bCursor; i < M; i++) {
            merge[cursor++] = B[i];
        }

        System.out.println(
                Arrays.stream(merge)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "))
        );
    }
}

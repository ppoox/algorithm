package baekjoon.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No15651 {
    static int n, m;
    static int[] selected, used;
    static StringBuilder sb = new StringBuilder();

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        selected = new int[m + 1];
        used = new int[n];

        br.close();
    }

    public static void main(String[] args) throws IOException {
        input();
        recursive(1);
        System.out.println(sb);
    }

    private static void recursive(int d) {
        if (d == m + 1) {
            for (int i = 1; i <= m; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= n; i++) {
                selected[d] = i;
                recursive(d + 1);
                selected[d] = 0;
            }
        }
    }
}

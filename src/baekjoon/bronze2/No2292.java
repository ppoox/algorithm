package baekjoon.bronze2;

import java.util.Scanner;

public class No2292 {
    public static void main(String[] args) {

        // 1
        // 7 (+6) n
        // 19 (+12) 3
        // 37 (+18)
        // 61 (+24)

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(solve(N));
    }

    public static int solve(int N) {
        int level = 0;
        int start = 0;
        int cnt = 0;

        while (true) {
            cnt++;

            if (start < N && N <= 1 + 6 * level) {
                break;
            }

            start = 1 + 6 * level;
            level += cnt;
        }

        return cnt;
    }
}

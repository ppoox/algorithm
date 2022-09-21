package kimtaeone.twopointer;

import java.util.Scanner;

public class ConsecutiveSubsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ns = new int[n];
        for (int i = 0; i < n; i++) {
            ns[i] = sc.nextInt();
        }

        solution(n, m, ns);
    }

    private static void solution(int n, int m, int[] ns) {
        int cnt = 0, lt = 0, sum = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += ns[rt];
            if (sum == m) cnt++;
            while (sum >= m) {
                sum -= ns[lt++];
                if (sum == m) cnt++;
            }
        }

        System.out.println(cnt);
    }

}

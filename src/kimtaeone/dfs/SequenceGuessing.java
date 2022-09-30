package kimtaeone.dfs;

import java.util.Scanner;

public class SequenceGuessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = sc.nextInt();

        solution(n, f);
    }

    static int[] b;
    static int[] p;
    static int[] ck;

    static boolean flag = false;

    private static void solution(int n, int f) {
        b = new int[n];
        p = new int[n];
        ck = new int[n + 1];
        for (int i = 0; i < n; i++) {
            b[i] = combination(n - 1, i);
        }

        DFS(n, f, 0, 0);
    }

    private static void DFS(int n, int f, int d, int sum) {
        if (d == n) {
            if (flag) {
                return;
            }
            if (sum == f) {
                flag = true;
                for (int i = 0; i < n; i++) {
                    System.out.print(p[i] + " ");
                }
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (ck[i] == 0) {
                ck[i] = 1;
                p[d] = i;
                DFS(n, f, d + 1, sum + (b[d] * p[d]));
                ck[i] = 0;
            }
        }
    }

    private static int combination(int n, int r) {
        return factorial(n) / (factorial(n - r) * factorial(r));
    }

    private static int factorial(int n) {
        return n <= 1 ? 1 : n * factorial(n - 1);
    }

}

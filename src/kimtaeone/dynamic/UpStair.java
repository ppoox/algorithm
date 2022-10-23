package kimtaeone.dynamic;

import java.util.Scanner;

public class UpStair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }

    private static void solution(int n) {
        int[] dy = new int[n+1];

        dy[0] = 1;
        dy[1] = 2;

        for (int i = 2; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }

        System.out.println(dy[n]);
    }
}

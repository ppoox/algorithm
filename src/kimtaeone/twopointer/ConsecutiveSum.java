package kimtaeone.twopointer;

import java.util.Scanner;

public class ConsecutiveSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution2(n);
    }

    private static void solution(int n) {
        int cnt = 0, lt = 1, sum = 0;
        for (int i = 1; i <= (n/2)+1; i++) {
            sum += i;
            if (sum == n) cnt++;
            while (sum >= n) {
                sum -= lt++;
                if (sum == n) cnt++;
            }

        }

        System.out.println(cnt);
    }

    private static void solution2(int n) {

        int cnt = 0;

        outer:
        for (int i = 2; i <= (n / 2) + 1; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += j;
                if (sum > n) {
                    continue outer;
                }
            }

            if ((n - sum) % i == 0) {
                cnt++;
                for (int j = 1; j <= i; j++) {
//                    System.out.print(j+((n - sum)/i) + " ");
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }

        System.out.println(cnt);
    }
}

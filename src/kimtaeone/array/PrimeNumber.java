package kimtaeone.array;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        solution(n);
    }

    private static void solution(int n) {
        int[] primes = new int[n+1];
        primes[0] = 1;
        primes[1] = 1;
        for (int i = 2; (i * i) <= n; i++) {
            for (int j = (i * i); j <= n; j += i) {
                primes[j] = 1;
            }
        }
        int primeCnt = 0;
        for (int p : primes) {
            if (p == 0) primeCnt++;
        }

        System.out.println(primeCnt);
    }

}

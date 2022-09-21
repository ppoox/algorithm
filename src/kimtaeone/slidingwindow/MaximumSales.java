package kimtaeone.slidingwindow;

import java.util.Scanner;

public class MaximumSales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] ns = new int[n];
        for (int i = 0; i < n; i++) {
            ns[i] = sc.nextInt();
        }

        solution(n, k, ns);

    }

    private static void solution(int n, int k, int[] ns) {
        int maxSales = 0;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += ns[i];
        }
        maxSales = sum;
        for (int i = k; i <= n - k; i++) {
            sum = sum - ns[i-k] + ns[i];
            System.out.println(i + " / " + sum + " / " + maxSales);
            if (sum > maxSales) {
                maxSales = sum;
            }

        }

        System.out.println(maxSales);
    }
}

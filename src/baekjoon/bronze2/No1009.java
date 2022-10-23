package baekjoon.bronze2;

import java.util.Scanner;

public class No1009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                data[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int result = 1;
            for (int j = 1; j <= data[i][1]; j++) {
                result = (result * data[i][0]) % 10;
            }
            System.out.println(result == 0 ? 10 : result);
        }
    }
}

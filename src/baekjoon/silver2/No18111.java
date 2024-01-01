package baekjoon.silver2;

import java.util.Scanner;

public class No18111 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int b = sc.nextInt();

        int max = 0;
        int[][] area = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                area[i][j] = sc.nextInt();
                if (area[i][j] > max) {
                    max = area[i][j];
                }
            }
        }

        int time = 0;
        while (true) {
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    sum += (max - area[i][j]);
                    if (max - 1 == area[i][j]) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
            if (cnt < (n * m) / 2) {
                time += (cnt * 2);
                max--;
                System.out.println(time + " " + max);
                break;
            }

            if (b >= sum) {
                time += sum;
                System.out.println(time + " " + max);
                break;
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (area[i][j] == max) {
                            time += 2;
                            b++;
                            area[i][j]--;
                        }
                    }
                }
                max--;
            }
        }
    }
}

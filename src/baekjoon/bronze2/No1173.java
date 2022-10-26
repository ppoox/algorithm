package baekjoon.bronze2;

import java.util.Scanner;

public class No1173 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt();

        if (M - m < T) {
            System.out.println(-1);
            return;
        }

        int workCnt = 0;
        int workMinute = 0;
        int value = m;
        while (workMinute < N) {
            workCnt++;
            if (value + T <= M) {
                value += T;
                workMinute++;
            } else {
                value -= R;
                if (value < m) {
                    value = m;
                }
            }
        }

        System.out.println(workCnt);
    }
}

package baekjoon.bronze2;

import java.util.Scanner;

public class No1075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int F = sc.nextInt();

        int lastTwoNumber = N % 100;
        int startNumber = N - lastTwoNumber;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 100; i++) {
            if (startNumber % F == 0) {
                int r = startNumber % 100;
                if (r < 10) {
                    sb.append("0");
                }
                sb.append(r);
                break;
            }
            startNumber += 1;
        }

        System.out.println(sb);
    }
}

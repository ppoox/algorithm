package baekjoon.bronze2;

import java.util.Scanner;

public class No1100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        char[][] chess = new char[8][8];
//        for (int i = 0; i < 8; i++) {
//            chess[i] = sc.next().toCharArray();
//        }
        String[] chess = new String[8];
        for (int i = 0; i < 8; i++) {
            chess[i] = sc.next();
        }

        int cnt = 0;
        for (int y = 0; y < 8; y++) {
            for (int x = y % 2; x < 8; x += 2) {
                if ('F' == chess[y].charAt(x)) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}

package baekjoon.bronze3;

import java.util.Scanner;

public class No1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int min = Integer.MAX_VALUE;
        min = Math.min(min, x);
        min = Math.min(min, y);
        min = Math.min(min, Math.abs(w - x));
        min = Math.min(min, Math.abs(h - y));

        System.out.println(min);
    }
}

package baekjoon.silver5;

import java.util.Scanner;

public class No2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();

        int remain = v - a;
        if (remain == 0) {
            System.out.println(1);
            return;
        }

        int cnt = 0;
        if (remain < (a - b)) {
            cnt = remain / (a - b) + 1;
        } else {
            if (remain % (a - b) >= 1) {
                cnt = remain / (a - b) + 1;
            } else {
                cnt = remain / (a - b);
            }
        }
        cnt++;

        System.out.println(cnt);
    }
}

package baekjoon.bronze1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        int len = -1;
        while (len != list.size()) {
            int min = Math.min(n, m);
            len = list.size();
            for (int i = 2; i <= min; i++) {
                if (n % i == 0 && m % i == 0) {
                    n /= i;
                    m /= i;
                    list.add(i);
                    break;
                }
            }
        }

        int gcd = 1;
        for (int v : list) {
            gcd *= v;
        }

        int lcm = gcd * n * m;

        System.out.println(gcd);
        System.out.println(lcm);
    }
}

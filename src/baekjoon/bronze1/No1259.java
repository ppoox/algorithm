package baekjoon.bronze1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Boolean> results = new ArrayList<>();

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            String str = Integer.toString(n);
            int len = str.length();
            boolean isPalindrome = true;
            for (int i = 0; i < len / 2; i++) {
                if (str.charAt(i) != str.charAt(len - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }
            results.add(isPalindrome);
        }

        for (boolean r : results) {
            System.out.println(r ? "yes" : "no");
        }
    }
}

package baekjoon.silver5;

import java.util.Scanner;

public class No1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        int result = 0;

        outerLoop:
        for (String word : words) {
            int[] alphabets = new int[26];
            char[] chars = word.toCharArray();
            char prev = chars[0];
            alphabets[prev - 97] += 1;

            for (int i = 1; i < chars.length; i++) {
                if (prev != chars[i] && alphabets[chars[i] - 97] != 0) {
                    continue outerLoop;
                }
                prev = chars[i];
                alphabets[prev - 97] += 1;
            }
            result++;
        }
        System.out.println(result);
    }
}

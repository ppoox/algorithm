package baekjoon.silver5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No1181 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = sc.next();
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String min = strs[i];

            for (int j = i + 1; j < N; j++) {
                if (min.length() == strs[j].length() && strs[j].compareTo(min) < 0 || min.length() > strs[j].length()) {
                    String temp = min;
                    min = strs[j];
                    strs[j] = temp;
                }
            }
            if (!list.contains(min)) {
                list.add(min);
            }
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}

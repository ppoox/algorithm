package baekjoon.bronze2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No8958 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String ox = sc.next();
            int score = 0;
            int continuous = 2;
            char prev = '#';
            for (char c : ox.toCharArray()) {
                if (c == 'O') {
                    if (prev == 'O') {
                        score += continuous;
                        continuous++;
                    } else  {
                        score++;
                    }
                } else {
                    continuous = 2;
                }
                prev = c;
            }
            list.add(String.valueOf(score));
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}

package baekjoon.bronze2;

import java.util.*;

public class No2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int R = sc.nextInt();
            String S = sc.next();
            StringBuilder sb = new StringBuilder();
            for (char c : S.toCharArray()) {
                for (int j = 0; j < R; j++) {
                    sb.append(c);
                }
            }
            list.add(sb.toString());
        }

        for (String l : list) {
            System.out.println(l);
        }
    }
}

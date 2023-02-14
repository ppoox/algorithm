package baekjoon.bronze3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            int floor = N % H;
            int room = N / H;
            if (floor != 0) {
                room++;
            }
            if (floor == 0) {
                floor = H;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(floor);
            if (room < 10) {
                sb.append("0");
            }
            sb.append(room);

            list.add(sb.toString());
        }

        for (String v : list) {
            System.out.println(v);
        }

        sc.close();
    }
}

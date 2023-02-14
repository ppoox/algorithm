package baekjoon.bronze5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No10951 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if ("".equals(line)) {
                break;
            }
            String[] s = line.split(" ");
            list.add(Integer.parseInt(s[0]) + Integer.parseInt(s[1]));
        }

        for (int i : list) {
            System.out.println(i);
        }
    }
}

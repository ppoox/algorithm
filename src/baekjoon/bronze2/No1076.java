package baekjoon.bronze2;

import java.util.Scanner;

public class No1076 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] resistances = new String[3];
        for (int i = 0; i < resistances.length; i++) {
            resistances[i] = sc.next();
        }

        String[][] table = {
                {"black", "0", "1"},
                {"brown", "1", "10"},
                {"red", "2", "100"},
                {"orange", "3", "1000"},
                {"yellow", "4", "10000"},
                {"green", "5", "100000"},
                {"blue", "6", "1000000"},
                {"violet", "7", "10000000"},
                {"grey", "8", "100000000"},
                {"white", "9", "1000000000"},
        };

        long first = 0;
        long second = 0;
        long third = 0;
        for (int j = 0; j < table.length; j++) {
            if (table[j][0].equals(resistances[0])) {
                first = Long.parseLong(table[j][1]) * 10;
            }
            if (table[j][0].equals(resistances[1])) {
                second = Long.parseLong(table[j][1]);
            }
            if (table[j][0].equals(resistances[2])) {
                third = Long.parseLong(table[j][2]);
            }
        }

        System.out.println((first + second) * third);
    }
}

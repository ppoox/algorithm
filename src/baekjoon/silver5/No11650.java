package baekjoon.silver5;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Pointer implements Comparable<Pointer> {
    int x;
    int y;

    public Pointer(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(@NotNull Pointer o) {
        if (x == o.x) {
            return y - o.y;
        }
        return x - o.x;
    }
}

public class No11650 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Pointer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pointer(sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(list);

        for (Pointer p : list) {
            System.out.println(p.x + " " + p.y);
        }
    }
}

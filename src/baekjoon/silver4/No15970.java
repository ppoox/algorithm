package baekjoon.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class No15970 {
    static int N;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(calculate());
    }

    public static int calculate() {
        int sum = 0;
        for (ArrayList<Integer> colors : list) {
            Collections.sort(colors);
            for (int i = 0; i < colors.size(); i++) {
                if (i == 0) {
                    sum += colors.get(i + 1) - colors.get(i);
                } else if (i == colors.size() - 1) {
                    sum += colors.get(i) - colors.get(i - 1);
                } else {
                    sum += Math.min(colors.get(i) - colors.get(i - 1), colors.get(i + 1) - colors.get(i));
                }
            }
        }
        return sum;
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] xy = line.split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            list.get(y).add(x);
        }

        br.close();
    }
}

package kimtaeone.sort;

import java.util.Scanner;

class Point implements Comparable<Point> {
    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}

public class CoordinateSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] coordiantes = new int[n][2];
        for (int i = 0; i < n; i++) {
            coordiantes[i][0] = sc.nextInt();
            coordiantes[i][1] = sc.nextInt();
        }

        solution(coordiantes);
    }

    private static void solution(int[][] coordiantes) {
        int n = coordiantes.length;
        for (int i = 0; i < n; i++) {
            int max = -1;
            for (int j = 0; j < n - i - 1; j++) {
                if (coordiantes[j][0] > coordiantes[j + 1][0]) {
                    swap(coordiantes, j, j + 1);
                } else if (coordiantes[j][0] == coordiantes[j + 1][0]) {
                    if (coordiantes[j][1] > coordiantes[j + 1][1]) {
                        swap(coordiantes, j, j + 1);
                    }
                }
            }
        }

        for (int[] r : coordiantes) {
            System.out.println(r[0] + " " + r[1]);
        }
    }

    private static void swap(int[][] coordiantes, int lt, int rt) {
        int[] temp = coordiantes[lt];
        coordiantes[lt] = coordiantes[rt];
        coordiantes[rt] = temp;
    }
}

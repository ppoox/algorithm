package kimtaeone.dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class HighestTower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] bricks = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                bricks[i][j] = sc.nextInt();
            }
        }

        solution(bricks);
    }

    private static void solution(int[][] bricks) {
        int n = bricks.length;
        int[] dy = new int[n];

        Arrays.sort(bricks, (o1, o2) -> o2[0] - o1[0]);

        dy[0] = bricks[0][1];

        for (int[] b : bricks) {
            System.out.println(Arrays.toString(b));
        }

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i; j >= 0; j--) {
                if (bricks[j][2] > bricks[i][2]) {
                    max = Math.max(max, dy[j]);

                }
            }
            dy[i] = max + bricks[i][1];
        }

        System.out.println(Arrays.stream(dy).max().getAsInt());
    }
}

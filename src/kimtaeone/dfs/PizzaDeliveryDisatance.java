package kimtaeone.dfs;

import java.util.Scanner;

public class PizzaDeliveryDisatance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maps = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maps[i][j] = sc.nextInt();
            }
        }

        solution(maps, m);
    }

    private static void solution(int[][] maps, int m) {
        int n = maps.length;

    }


}

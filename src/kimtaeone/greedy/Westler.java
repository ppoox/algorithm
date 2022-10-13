package kimtaeone.greedy;

import java.util.Scanner;

public class Westler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] athletes = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                athletes[i][j] = sc.nextInt();
            }
        }

        solution(athletes);
    }

    private static void solution(int[][] athletes) {
        int n = athletes.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            boolean isSelection = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (athletes[i][0] < athletes[j][0] && athletes[i][1] < athletes[j][1]) {
                    isSelection = false;
                }
            }
            if (isSelection) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

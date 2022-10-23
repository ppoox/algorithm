package kimtaeone.array;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Mentoring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] scores = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                scores[i][j] = sc.nextInt();
            }
        }

        solution(scores);
    }

    private static void solution(int[][] scores) {
        int n = scores.length;
        int m = scores[0].length;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    set.add(scores[i][j] + "^" + scores[i][k]);
                }
            }
        }

        int cnt = 0;
        for (String s : set) {
            String[] splits = s.split("\\^");
            cnt += set.contains(splits[1] + "^" + splits[0]) ? 0 : 1;
        }

        System.out.println(cnt);
    }
}
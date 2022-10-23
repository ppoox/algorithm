package kimtaeone.array;

import java.util.Scanner;

public class TemporaryRepresent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] graph = new int[n+1][6];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        solution(graph);
    }

    private static void solution(int[][] graph) {
        int n = graph.length-1;
        int max = Integer.MIN_VALUE;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 5; k++) {
                    if (graph[i][k] == graph[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                answer = i;
            }
        }

        System.out.println(answer);
    }
}

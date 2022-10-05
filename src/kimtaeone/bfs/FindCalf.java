package kimtaeone.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindCalf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();

        solution(s, e);
    }

    private static void solution(int s, int e) {
        int[] dis = {1, -1, 5};
        Queue<Integer> queue = new LinkedList<>();
        int[] check = new int[10001];
        queue.offer(s);
        int d = 0;

        outer:
        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                int location = queue.poll();
                for (int j = 0; j < 3; j++) {
                    int v = location + dis[j];
                    if (location == e) {
                        break outer;
                    }
                    if (v >= 1 && v <= 10000 && check[v] == 0) {
                        check[v] = 1;
                        queue.offer(v);
                    }
                }
            }
            System.out.print(queue);
            System.out.print(" / ");
            System.out.println(Arrays.toString(check));
            d++;
        }

        System.out.println(d);
    }

}

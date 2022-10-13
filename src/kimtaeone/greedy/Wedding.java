package kimtaeone.greedy;

import java.util.*;

public class Wedding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] friends = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                friends[i][j] = sc.nextInt();
            }
        }

        solution(friends);
    }

    private static void solution(int[][] friends) {

        Arrays.sort(friends, Comparator.comparingInt(f -> f[0]));

        for (int[] f : friends) {
            System.out.println(Arrays.toString(f));
        }

        Queue<Integer> priorQueue = new PriorityQueue<>();

        int max = 0;
        for (int i = 0; i < friends.length; i++) {

            if (!priorQueue.isEmpty()) {
                int peek = priorQueue.peek();
                if (peek <= friends[i][0]) {
                    priorQueue.poll();
                }
            }

            priorQueue.offer(friends[i][1]);

            max = Math.max(max, priorQueue.size());
        }
        System.out.println(max);
    }
}

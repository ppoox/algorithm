package kimtaeone.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SafePrincess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        solution(n, k);
    }

    private static void solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int s = 0;
        while (queue.size() > 1) {
            s++;
            Integer poll = queue.poll();

            if (s < k) {
                queue.add(poll);
            } else {
                s = 0;
            }
        }

        System.out.println(queue.poll());
    }
}

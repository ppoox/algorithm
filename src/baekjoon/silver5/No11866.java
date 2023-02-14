package baekjoon.silver5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No11866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (cnt == k) {
                sb.append(poll);
                sb.append(", ");
                cnt = 1;
            } else {
                queue.offer(poll);
                cnt++;
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append('>');

        System.out.println(sb);
    }
}

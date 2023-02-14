package baekjoon.silver4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        boolean rmFlag = true;
        while (queue.size() > 1) {
            Integer poll = queue.poll();
            if (!rmFlag) queue.offer(poll);
            rmFlag = !rmFlag;
        }

        System.out.println(queue.poll());
        sc.close();
    }
}

package baekjoon.silver4;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class No10866 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            if ("push_front".equals(command)) {
                deque.addFirst(sc.nextInt());
                continue;
            } else if ("push_back".equals(command)) {
                deque.addLast(sc.nextInt());
                continue;
            } else if ("pop_front".equals(command)) {
                if (deque.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(deque.pollFirst());
                }
            } else if ("pop_back".equals(command)) {
                if (deque.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(deque.pollLast());
                }
            } else if ("size".equals(command)) {
                sb.append(deque.size());
            } else if ("empty".equals(command)) {
                sb.append(deque.isEmpty() ? 1 : 0);
            } else if ("front".equals(command)) {
                if (deque.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(deque.peekFirst());
                }
            } else if ("back".equals(command)) {
                if (deque.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(deque.peekLast());
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}

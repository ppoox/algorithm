package baekjoon.silver4;

import java.util.*;

public class No10845 {
    public static void main(String[] args) {
//        push X: 정수 X를 큐에 넣는 연산이다.
//        pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//        size: 큐에 들어있는 정수의 개수를 출력한다.
//        empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
//        front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//        back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String action = sc.next();
            if ("push".equals(action)) {
                queue.offer(sc.nextInt());
                continue;
            } else if ("pop".equals(action)) {
                sb.append(queue.isEmpty() ? -1 : queue.poll());
            } else if ("size".equals(action)) {
                sb.append(queue.size());
            } else if ("empty".equals(action)) {
                sb.append(queue.isEmpty() ? 1 : 0);
            } else if ("front".equals(action)) {
                sb.append(queue.isEmpty() ? -1 : queue.peekFirst());
            } else if ("back".equals(action)) {
                sb.append(queue.isEmpty() ? -1 : queue.peekLast());
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}

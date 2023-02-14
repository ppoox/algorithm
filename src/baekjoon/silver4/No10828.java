package baekjoon.silver4;

import java.util.Scanner;
import java.util.Stack;

public class No10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            if ("push".equals(command)) {
                stack.push(sc.nextInt());
                continue;
            } else if ("pop".equals(command)) {
                if (stack.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(stack.pop());
                }
            } else if ("size".equals(command)) {
                sb.append(stack.size());
            } else if ("empty".equals(command)) {
                sb.append(stack.isEmpty() ? 1 : 0);
            } else if ("top".equals(command)) {
                if (stack.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(stack.peek());
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

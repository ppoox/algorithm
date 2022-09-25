package kimtaeone.stack;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        solution(s);

    }

    private static void solution(String s) {
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.push(stack.pop() * stack.pop());
            } else if (c == '/') {
                stack.push(stack.pop() / stack.pop());
            } else if (c == '+') {
                stack.push(stack.pop() + stack.pop());
            } else if (c == '-') {
                int v1 = stack.pop();
                int v2 = stack.pop();
                stack.push(v2 - v1);
            } else {
                stack.push(Character.digit(c, 10));
            }
        }

        System.out.println(stack.pop());
    }
}

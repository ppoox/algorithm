package kimtaeone.stack;

import java.util.Scanner;
import java.util.Stack;

public class CollectBracket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String b = sc.next();

        solution2(b);
    }

    private static void solution(String b) {
        Stack<Character> stack = new Stack<>();
        String result = "YES";
        for (char c : b.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    result = "NO";
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            result = "NO";
        }

        System.out.println(result);
    }

    public static void solution2(String b) {
        Stack<Character> stack = new Stack<>();
        String result = "YES";
        for (char c : b.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    result = "NO";
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            result = "NO";
        }

        System.out.println(result);
    }
}

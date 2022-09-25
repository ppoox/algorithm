package kimtaeone.stack;

import java.util.Scanner;
import java.util.Stack;

public class IronStick {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        solution(s);
    }

    private static void solution(String s) {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        char prev = '\0';
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
                if (prev == '(') {
                    cnt += stack.size();
                } else {
                    cnt += 1;
                }
            }
            prev = c;
        }

        System.out.println(cnt);
    }
}

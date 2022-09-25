package kimtaeone.stack;

import java.util.Scanner;
import java.util.Stack;

public class RemoveBracket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        solution(s);
    }

    private static void solution(String s) {
        Stack<Character> stack = new Stack<>();
        String answer = "";
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
            } else if (stack.isEmpty()){
                answer += c;
            }
        }

        System.out.println(answer);
    }
}

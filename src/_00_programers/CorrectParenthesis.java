package _00_programers;

import java.util.Stack;

public class CorrectParenthesis {
    public static void main(String[] args) {
//        "()()"	true
//        "(())()"	true
//        ")()("	false
//        "(()("	false
        String s1 = "(()(";
        System.out.println(new CorrectParenthesis().solution(s1));
    }

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else if (c == ')') {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop != '(') {
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }

        return true;
    }
}

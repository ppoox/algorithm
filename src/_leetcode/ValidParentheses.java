package _leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    private final static String PARENTHESES_OPEN_S = "(";
    private final static String PARENTHESES_OPEN_M = "{";
    private final static String PARENTHESES_OPEN_L = "[";
    private final static String PARENTHESES_CLOSE_S = ")";
    private final static String PARENTHESES_CLOSE_M = "}";
    private final static String PARENTHESES_CLOSE_L = "]";


    public static void main(String[] args) {

        System.out.println(isValid("({})"));
    }

    public static boolean isValid(String s) {
        Stack stack = new Stack();

        String[] splitStrArray = s.split("");
        for(String splitStr : splitStrArray) {
            if(PARENTHESES_OPEN_S.equals(splitStr) || PARENTHESES_OPEN_M.equals(splitStr) || PARENTHESES_OPEN_L.equals(splitStr)) {
                stack.push(splitStr);
                continue;
            }

            if(PARENTHESES_CLOSE_S.equals(splitStr)) {
                if(stack.empty() || !PARENTHESES_OPEN_S.equals(stack.peek())) {
                    return false;
                }
                stack.pop();
            }
            if(PARENTHESES_CLOSE_M.equals(splitStr)) {
                if(stack.empty() || !PARENTHESES_OPEN_M.equals(stack.peek())) {
                    return false;
                }
                stack.pop();
            }
            if(PARENTHESES_CLOSE_L.equals(splitStr)) {
                if(stack.empty() || !PARENTHESES_OPEN_L.equals(stack.peek())) {
                    return false;
                }
                stack.pop();
            }
        }
        if(!stack.empty()) {
            return false;
        }

        return true;
    }




    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public ValidParentheses() {
        this.mappings = new HashMap<>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid2(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}

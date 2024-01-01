package baekjoon.silver4;

import java.io.*;
import java.util.Stack;

public class No4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = br.readLine();
            if (".".equals(str)) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            if (isCollectClosed(str, stack) && stack.size() == 0) {
                bw.write("yes" + "\n");
            } else {
                bw.write("no" + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static boolean isCollectClosed(String str, Stack<Character> stack) {
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty()) {
                    return false;
                } else {
                    if (stack.pop() != '(') {
                        return false;
                    }
                }
            } else if (c == ']') {
                if (stack.empty()) {
                    return false;
                } else {
                    if (stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

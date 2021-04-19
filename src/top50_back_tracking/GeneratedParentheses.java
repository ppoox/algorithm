package top50_back_tracking;

import java.util.ArrayList;
import java.util.List;

public class GeneratedParentheses {
    public static void main(String[] args) {
        System.out.println(solve(3));
    }

    public static List<String> solve(int n) {
        List<String> result = new ArrayList<>();

        dfs(result, "", n, n, "");

        return result;
    }

    public static void dfs(List<String> list, String str, int left, int right, String str1) {
        System.out.println("str " + str + " / " + left + " / " + right);

        if (left < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            list.add(str);
        }
        dfs(list, str + '(', left-1, right, str + "hello");
        dfs(list, str + ')', left, right-1, str + "hello");
    }
}

package kimtaeone.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveDistinctString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        List<Character> list = new ArrayList<>();

        for (char c : str.toCharArray()) {
            if (!list.contains(c)) {
                list.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}

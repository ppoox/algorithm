package kimtaeone.string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShortDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(solution(sc.next(), sc.next().charAt(0)));
    }

    private static String solution(String s, char t) {
        char[] sChars = s.toCharArray();
        int[] distance = new int[sChars.length];
        for (int i=0; i<sChars.length; i++) {
            distance[i] = Math.min(search(s, t, i, -1, 0), search(s, t, i, 1, 0));
        }

        return Arrays.stream(distance).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private static int search(String s, char t, int i, int v, int cnt) {
        if (i < 0 || i >= s.length()) return Integer.MAX_VALUE;
        return s.charAt(i) == t ? cnt : search(s, t, i + v, v, ++cnt);
    }
}

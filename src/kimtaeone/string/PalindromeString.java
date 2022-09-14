package kimtaeone.string;

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(solution(sc.next()));
    }

    private static String solution(String str) {
        str = str.toLowerCase();

        char[] strChars = str.toCharArray();
        int left = 0;
        int right = strChars.length-1;
        while (left < right) {
            if (strChars[left] == strChars[right]) {
                left++;
                right--;
            } else {
                return "NO";
            }
        }

        return "YES";
    }

}

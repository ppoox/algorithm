package kimtaeone.string;

import java.util.Scanner;

public class ReverseSpecialWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(solution(str));
    }

    public static String solution(String str) {

        char[] strChars = str.toCharArray();
        int left = 0;
        int right = strChars.length-1;

        while (left < right) {
            if (!Character.isAlphabetic(strChars[left])) {
                left++;
            } else if (!Character.isAlphabetic(strChars[right])) {
                right--;
            } else {
                char temp = strChars[left];
                strChars[left] = strChars[right];
                strChars[right] = temp;
                left++;
                right--;
            }

        }

        return String.valueOf(strChars);
    }
}

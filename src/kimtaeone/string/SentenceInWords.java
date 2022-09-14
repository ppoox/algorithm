package kimtaeone.string;

import java.util.Scanner;

public class SentenceInWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String[] splitStr = str.split(" ");
        String answer = "";
        for (String s : splitStr) {
            if (s.length() > answer.length()) {
                answer = s;
            }
        }

        return answer;
    }
}

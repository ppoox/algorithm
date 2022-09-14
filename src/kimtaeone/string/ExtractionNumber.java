package kimtaeone.string;

import java.util.Scanner;

public class ExtractionNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(solution(sc.next()));
    }

    private static int solution(String str) {

        int answer = 0;
        for (char c : str.toCharArray()) {
            if (c >= 48 && c <= 57) {
                answer = answer * 10 + (c - 48);
            }
        }

        return answer;
    }
}

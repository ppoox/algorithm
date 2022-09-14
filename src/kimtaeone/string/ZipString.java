package kimtaeone.string;

import java.util.Scanner;

public class ZipString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(solution(sc.next()));

    }

    private static String solution(String str) {

        char prev = '0';
        int zip = 1;
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (prev == '0') {
                prev = c;
                continue;
            }
            if (prev == c) {
                zip++;
            } else {
                sb.append(prev);
                if (zip > 1) {
                    sb.append(zip);
                    zip = 1;
                }
            }
            prev = c;
        }
        sb.append(prev);
        if (zip > 1) {
            sb.append(zip);
        }
        System.out.println(sb);
        return sb.toString();
    }
}

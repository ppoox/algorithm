package kimtaeone.string;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        solution(n, s);
    }

    private static void solution(int n, String s) {
        int strLen = s.length() / n;
        int cnt = 0;
        StringBuilder answer = new StringBuilder();
        String str = "";

        for (char c : s.toCharArray()) {
            cnt++;
            if (c == '*') {
                str += 0;
            } else if (c == '#') {
                str += 1;
            }
            if (cnt == strLen) {
//                int num = 0;
//                for (int i = 1; i <= cnt; i++) {
//                    num += (str.charAt(cnt - i) - '0') * (int) Math.pow(2, i-1);
//                }
//                answer.append((char) num);
                answer.append((char) Integer.parseInt(str, 2));
                str = "";
                cnt = 0;
            }
        }

        System.out.println(answer);
    }
}

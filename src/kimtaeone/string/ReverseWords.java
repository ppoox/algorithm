package kimtaeone.string;

import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        for (String str : strs) {
            System.out.println(solution(str));
        }
    }

    public static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        return sb.append(str).reverse().toString();
    }
}

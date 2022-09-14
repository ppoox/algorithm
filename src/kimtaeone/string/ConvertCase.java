package kimtaeone.string;

import java.util.Scanner;

public class ConvertCase {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next();

        System.out.println(solution((input1)));
    }

    public static String solution(String str) {

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            }
        }

        return sb.toString();
    }
}

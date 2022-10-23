package leetcode;

import java.util.regex.Pattern;

public class levelOrder {
    public static void main(String[] args) {
        String regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[`~!@#$%^&*()_=+:;,./|?<>{}'\\-\"\\[\\]\\\\])[A-Za-z\\d`~!@#$%^&*()_=+:;,./|?<>{}'\\-\"\\[\\]\\\\]{10,14}$";

        System.out.println("False: " + Pattern.matches(regexp, "qwer12345"));
        System.out.println("False: " + Pattern.matches(regexp, "qwer123456"));
        System.out.println("False: " + Pattern.matches(regexp, "qwer12345asd"));
        System.out.println("False: " + Pattern.matches(regexp, "141asdas34"));
        System.out.println("False: " + Pattern.matches(regexp, "asdasdasasdas"));
        System.out.println("False: " + Pattern.matches(regexp, "13576457845678"));


        System.out.println("True: " + Pattern.matches(regexp, "qwer12345`"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345~"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345!"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345@"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345#"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345$"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345%"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345^"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345&"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345*"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345("));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345)"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345-"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345_"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345="));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345+"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345["));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345{"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345]"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345}"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345,."));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345<>"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345/?"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345\\"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345\\|"));
        System.out.println("True: " + Pattern.matches(regexp, "12345asdas\\|"));
        System.out.println("True: " + Pattern.matches(regexp, "qwer12345\\|asd"));

    }

}

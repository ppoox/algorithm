package _leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class IntegerToRoman {
    private static final String ROMAN_SYMBOL_ONE = "I";
    private static final String ROMAN_SYMBOL_FIVE = "V";
    private static final String ROMAN_SYMBOL_TEN = "X";
    private static final String ROMAN_SYMBOL_FIFTY = "L";
    private static final String ROMAN_SYMBOL_HUNDRED = "C";
    private static final String ROMAN_SYMBOL_HALF_THOUSAND = "D";
    private static final String ROMAN_SYMBOL_THOUSAND = "M";

    public static void main(String[] args) {
//        Symbol       Value
//        I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        M             1000
//        D             500

//        Input: num = 3
//        Output: "III"
//        Example 2:
//
//        Input: num = 4
//        Output: "IV"
//        Example 3:
//
//        Input: num = 9
//        Output: "IX"
//        Example 4:
//
//        Input: num = 58
//        Output: "LVIII"
//        Explanation: L = 50, V = 5, III = 3.
//        Example 5:
//
//        Input: num = 1994
//        Output: "MCMXCIV"
//        Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

//        intToRoman(3);
//        intToRoman(4);
//        intToRoman(9);
//        intToRoman(58);
//        intToRoman(1994);
        intToRoman(3999);

    }
    public static String intToRoman(int num) {
        Deque deque = new ArrayDeque();
        int count = 0;
        while (num > 0) {
            int value = num % 10;

            if (count == 0) {
                deque.push(transRoman(value, ROMAN_SYMBOL_ONE, ROMAN_SYMBOL_FIVE, ROMAN_SYMBOL_TEN));
            }
            if (count == 1) {
                deque.push(transRoman(value, ROMAN_SYMBOL_TEN, ROMAN_SYMBOL_FIFTY, ROMAN_SYMBOL_HUNDRED));
            }
            if (count == 2) {
                deque.push(transRoman(value, ROMAN_SYMBOL_HUNDRED, ROMAN_SYMBOL_HALF_THOUSAND, ROMAN_SYMBOL_THOUSAND));
            }
            if (count == 3) {
                deque.push(transRoman(value, ROMAN_SYMBOL_THOUSAND, null, null));
            }

            num /= 10;
            count++;
        }

        return deque.stream().collect(Collectors.joining()).toString();
    }

    public static String transRoman(int value, String one, String five, String ten) {
        StringBuilder sb = new StringBuilder();
        if (value < 5) {
            if(value == 4) {
                sb.append(one + five);
            } else {
                for (int i = 0; i < value; i++) {
                    sb.append(one);
                }
            }
        }
        if (value >= 5) {
            if(value == 9) {
                sb.append(one + ten);
            } else {
                sb.append(five);
                for (int i = 0; i < value - 5; i++) {
                    sb.append(one);
                }
            }
        }

        return sb.toString();
    }

    public static String intToRomanBest(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}

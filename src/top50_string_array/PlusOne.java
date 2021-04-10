package top50_string_array;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
//		int[] digits = {1,2,3};
		int[] digits = {9,9,9};
//		int[] digits = {9,8,9};
//		int[] digits = {8,9,9};
//		int[] digits = {0,0,1};
//        int[] digits = {0,0};
//		int[] digits = {9,0,0,9};


        int[] result = new PlusOne().solve(digits);
        for (int i : result)
            System.out.println("val: " + i);
    }

    public int[] solve(int[] digits) {
        int[] result = {};

        int index = digits.length-1;
        int carry = 1;

        while (index >= 0 && carry > 0) {
            if((digits[index] + 1) / 10 < 1) {
                carry = 0;
            }
            digits[index] = (digits[index--] + 1) % 10;
        }

        if (carry == 1) {
            digits = new int[digits.length + 1];
            digits[0] = carry;
        }

        return digits;
    }


}

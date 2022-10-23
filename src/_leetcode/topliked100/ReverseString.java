package _leetcode.topliked100;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        int end = s.length-1;
        for (int i=0; i<s.length/2; i++) {
            char temp = s[end];
            s[end] = s[i];
            s[i] = temp;
            end--;
        }

        System.out.println(Arrays.toString(s));
    }
}

package _00_programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZipStr {
    public static void main(String[] args) {
        String s1 = "aabbaccc";                 //	7
        String s2 = "ababcdcdababcdcd";         //	9
        String s3 = "abcabcdede";               //	8
        String s4 = "abcabcabcabcdededededede"; //	14
        String s5 = "xababcdcdababcdcd";        //	17

        solution(s1);
    }

    public static int solution(String s) {
        int result = 0;
        List<String> list = new ArrayList<>();
        char[] sChars = s.toCharArray();
        for (int i = 1; i <= sChars.length / 2; i++) {
            String prev = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            int zipLevel = 1;
            for (int j = i; j <= sChars.length; j += i) {
                String temp = s.substring(j, Math.min(j + i, s.length()));
                if (temp.equals(prev)) {
                    zipLevel++;
                } else {
                    if (zipLevel > 1) {
                        sb.append(zipLevel);
                        zipLevel = 1;
                    }
                    sb.append(prev);
                    prev = temp;
                }
            }
            sb.append(prev);
            result = Math.min(result, sb.toString().length());
            list.add(sb.toString());
        }

        System.out.println(Arrays.toString(list.toArray()));
        return result;
    }

    public static String[] strSplitBySize(String s, int size) {
        List<String> list = new ArrayList<>();
        while (s.length() >= size) {
            list.add(s.substring(0, size));
            s = s.substring(size);
        }

        return list.toArray(new String[0]);
    }
}

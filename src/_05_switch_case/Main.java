package _05_switch_case;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String str = "helloWorlD";
        char[] arr = str.toCharArray();

        char a = 97;

        System.out.println(a);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] = (char) (arr[i] + 'A' - 'a');

            } else if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] = (char) (arr[i] - ('A' - 'a'));
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}



package _06_gcd;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int num1 = 17;
        int num2 = 18;
        int big=0, small=0;

        if(num1 >= num2) {
            big = num1;
            small = num2;
        }else {
            big = num2;
            small = num1;
        }

        int gcd = 1;
        for(int i=1; i<=small; i++) {
            if(small%i == 0 && big%i == 0) {
                gcd=i;
            }
        }

        System.out.println(gcd);
    }
}



package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DefangingIpAdress {
    public static void main(String[] args) {

    }

    public static String isPalindrome(String[] products) {
        for(int i=0; i<products.length; i++) {
            boolean isUnique = true;
            for(int j=0; j<products.length; j++) {
                if(i == j) continue;

                if(products[i].equals(products[j])) {
                    isUnique = false;
                }
            }
            if(isUnique) {
                return products[i];
            }
        }

        return null;
    }

}

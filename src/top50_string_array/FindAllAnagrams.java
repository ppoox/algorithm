package top50_string_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {

    public static void main(String[] args) {
        String txt = "BACDGABCDA";
        String pat = "ABCD";

        findAllAnagrams(txt, pat);
    }

    public static int[] findAllAnagrams(String txt, String pat) {
        List<Integer> list = new ArrayList<>();
        int[] patArr = new int[256];

        for(int i=0; i<pat.length(); i++) {
            patArr[pat.charAt(i)]++;
        }

        System.out.println(Arrays.toString(patArr));
        int index = 0;
        for(int i=0; i<txt.length()-pat.length()+1; i++) {
            int[] txtArr = new int[256];
            for(int j=0; j<pat.length(); j++) {
                txtArr[txt.charAt(i+j)]++;
            }
            if(Arrays.equals(patArr, txtArr)) {
                list.add(i);
                index++;
            }
        }

        return null;
    }
}

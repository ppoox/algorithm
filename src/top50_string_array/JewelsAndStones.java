package top50_string_array;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        System.out.println(solve(J, S));
    }

    public static int solve(String jewel, String stones) {
        int result = 0;
        Set<Character> set = new HashSet<>();
        for(char j : jewel.toCharArray()) {
            set.add(j);
        }

        for(char s : stones.toCharArray()) {
            if(set.contains(s)) result++;

        }



        return result;
    }

}

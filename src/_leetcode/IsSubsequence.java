package _leetcode;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));

        System.out.println(isSubsequence("ace", "abcde"));
        System.out.println(isSubsequence("aec", "abcde"));

    }

    public static boolean isSubsequence(String s, String t) {
        for (char sc : s.toCharArray()) {
            int idx = t.indexOf(sc);

            if (idx < 0) {
                return false;
            }

            t = t.substring(idx+1);
        }

        return true;
    }
}

package _leetcode.topliked100;

public class LongestPalindrome {
    public static void main(String[] args) {

        System.out.println(longestPalindrome("abccba"));

    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            int l1 = extend(s, i, i);  //assume odd length, try to extend Palindrome as possible
            int l2 = extend(s, i, i+1); //assume even length.

            int max = Math.max(l1, l2);

            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(start, end+1);
    }

    public static int extend(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right-left-1;
    }
}

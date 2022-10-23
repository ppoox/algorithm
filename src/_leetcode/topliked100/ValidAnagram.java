package _leetcode.topliked100;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("car", "rat"));
        System.out.println(new ValidAnagram().isAnagram("a", "ab"));
    }

    public boolean isAnagram(String s, String t) {
        int[] alphabets = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabets[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            alphabets[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] != 0) {
                return false;
            }
        }
        return true;
    }
}

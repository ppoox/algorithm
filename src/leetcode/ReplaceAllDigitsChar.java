package leetcode;

public class ReplaceAllDigitsChar {
    /**
     * You are given a 0-indexed string s that has lowercase English letters in its even indices and digits in its odd indices.
     * <p>
     * There is a function shift(c, x), where c is a character and x is a digit, that returns the xth character after c.
     * <p>
     * For example, shift('a', 5) = 'f' and shift('x', 0) = 'x'.
     * For every odd index i, you want to replace the digit s[i] with shift(s[i-1], s[i]).
     * <p>
     * Return s after replacing all digits. It is guaranteed that shift(s[i-1], s[i]) will never exceed 'z'.
     */
    public static void main(String[] args) {
        String result = new ReplaceAllDigitsChar().replaceDigits("a1b2c3d4e");
        System.out.println(result);
    }

    public String replaceDigits(String s) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        char[] inStrArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inStrArray.length; i++) {
            if (i % 2 == 1) {
                int alphabetIdx = alphabet.indexOf(inStrArray[i - 1]) + Character.getNumericValue(inStrArray[i]);
                sb.append(alphabet.substring(alphabetIdx, alphabetIdx + 1));
            } else {
                sb.append(inStrArray[i]);
            }
        }

        return sb.toString();
    }
}

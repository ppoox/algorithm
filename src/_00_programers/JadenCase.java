package _00_programers;

public class JadenCase {
    public static void main(String[] args) {
        new JadenCase().solution("3people unFollowed  me");
        new JadenCase().solution("for the last week");
    }
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s.toLowerCase();
        char prev = ' ';
        for (char c : s.toCharArray()) {
            sb.append(prev == ' ' ? Character.toUpperCase(c) : c);
            prev = c;
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    public int solution(String str, char t){
        int count = 0;
        str.toLowerCase();
        for (char c : str.toCharArray()) {
            if (c == t) count++;
        }

        int i = Character.toLowerCase(count);
        return count;
    }
}

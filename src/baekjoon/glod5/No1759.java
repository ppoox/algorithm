package baekjoon.glod5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class No1759 {
    static int L;
    static int C;
    static char[] characters;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        input();
        solve(0, "");
        System.out.println(sb.toString());
    }
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] LC = br.readLine().split(" ");
        L = Integer.parseInt(LC[0]);
        C = Integer.parseInt(LC[1]);
        characters = Arrays.stream(br.readLine().split(" ")).sorted().collect(Collectors.joining()).toCharArray();
        br.close();
    }
    public static void solve(int d, String password) {
        if (d >= C) {
            if (password.length() != L) {
                return;
            }
            if (!containsVowels(password)) {
                return;
            }
            if (!containsConsonant(password)) {
                return;
            }
            sb.append(password).append("\n");
        } else {
            solve(d + 1, password + characters[d]);
            solve(d + 1, password);
        }
    }
    public static boolean containsVowels(String str) {
        return str.contains("a") || str.contains("e") || str.contains("i") || str.contains("o") || str.contains("u");
    }
    public static boolean containsConsonant(String str) {
        return str.replaceAll("[aeiou]", "").length() >= 2;
    }
}

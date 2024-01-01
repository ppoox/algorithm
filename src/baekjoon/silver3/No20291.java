package baekjoon.silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class No20291 {
    static int N;
    static String[] fileNames;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        fileNames = new String[N];
        for (int i = 0; i < N; i++) {
            fileNames[i] = br.readLine();
        }
        br.close();
    }

    public static void solve() {
        Map<String, Integer> map = new HashMap<>();

        for (String fileName : fileNames) {
            String[] nameAndExt = fileName.split("\\.");
            map.put(nameAndExt[1], map.getOrDefault(nameAndExt[1], 0) + 1);
        }

        List<String> sortedKeys = map.keySet().stream().sorted().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (String key : sortedKeys) {
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }

        System.out.println(sb);
    }
}

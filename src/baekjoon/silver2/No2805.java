package baekjoon.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int tokenLength = st.countTokens();
        int[] trees = new int[tokenLength];
        for (int i = 0; i < tokenLength; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, m, trees));
    }

    public static int solution(int n, int m, int[] trees) {
        int max = Arrays.stream(trees).max().orElse(0);
        int min = 0;
        while (min < max) {
            int mid = (min + max) / 2;

            long sum = 0;

            for (int tree : trees) {
                if (tree - mid > 0) {
                    sum += tree - mid;
                }
            }

            if (sum < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min - 1;
    }

}

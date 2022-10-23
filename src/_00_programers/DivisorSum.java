package _00_programers;

import java.util.HashSet;
import java.util.Set;

public class DivisorSum {
    public static void main(String[] args) {
        new DivisorSum().solution(13, 17); // 43
    }

    public int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int sqrt = (int) Math.sqrt(i);
            Set<Integer> set = new HashSet<>();
            for (int j = 1; j <= sqrt; j++) {
                if (i % j == 0) {
                    set.add(j);

                    set.add(i / j);
                }
            }
            answer += i * (set.size() % 2 == 0 ? 1 : -1);
        }

        return answer;
    }
}

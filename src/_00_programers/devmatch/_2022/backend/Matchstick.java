package _00_programers.devmatch._2022.backend;

import java.util.LinkedList;
import java.util.Queue;

public class Matchstick {
    public static void main(String[] args) {
        new Matchstick().solution(5);
    }

    static int[] needs = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

    static int[] checks = new int[10];

    public long solution(int k) {
        if (k < 2) {
            return 0;
        }
        long answer = 0;


        for (int i = 0; i < needs.length; i++) {
            int remain = k - needs[i];
            if (remain < 0) {
                continue;
            } else if (remain < 2) {
                answer++;
                continue;
            }
            checks[i] = 1;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(remain);

            while (!queue.isEmpty()) {
                int len = queue.size();

                for (int j = 0; j < len; j++) {
                    int poll = queue.poll();

                }
            }

            checks[i] = 0;
        }


        return answer;
    }
}

package threeothree;

import java.util.*;

public class First {
    public static void main(String[] args) {
        String[] students1 = {"AAALLLAPAA", "AAAAAAAPPP", "ALAAAAPAAA"};
        String[] students2 = {"ALALLAAPAA", "ALLLAAAPAA", "APAPALLAAA"};
        String[] students3 = {};
        new First().solution(students1);
        new First().solution(students2);
    }

    public int[] solution(String[] students) {
        int n = students.length;
        int[] answer = new int[n];
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = -1;
        }
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparing(Integer::intValue).reversed());

        for (int i = 0; i < n; i++) {
            int score = 10;
            int lCnt = 0;
            int pCnt = 0;
            for (char c : students[i].toCharArray()) {
                if (c == 'A') {
                    score++;
                } else if (c == 'L') {
                    lCnt++;
                } else if (c == 'P') {
                    pCnt++;
                    score--;
                }
                if (lCnt >= 2) {
                    pCnt++;
                    score--;
                    lCnt = 0;
                } else if (pCnt >= 3) {
                    score = -1;
                    break;
                }
            }
            scores[i] = score;
            queue.add(score);
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i = 0; i < n; i++) {
                if (scores[i] == poll) {
                    answer[idx++] = i + 1;
                    scores[i] = -2;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}

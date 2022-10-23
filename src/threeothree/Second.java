package threeothree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Second {
    public static void main(String[] args) {
        int[][] orders = {
                {2, 3, 4, 0, 1},
                {1, 4, 3, 2, 0},
                {4, 1, 0, 2, 3},
                {3, 2, 1, 4, 0},
                {0, 3, 2, 1, 4}
        };

        System.out.println("result " + Arrays.toString(new Second().solution(orders)));
    }
    public int[] solution(int[][] orders) {
        int[] answer = new int[2];
        int n = orders.length;
        int[] votes = new int[n];
        int cnt = 0;

        while (cnt <= n) {
            cnt++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int candidate = orders[i][j];
                    if (votes[candidate] != -1) {
                        votes[candidate] += 1;
                        break;
                    }
                }
            }
            System.out.println(Arrays.toString(votes));

            int minVote = Integer.MAX_VALUE;
            List<Integer> minVotes = new ArrayList<>();
            List<Integer> elects = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (votes[i] == minVote) {
                    minVotes.add(i);
                }
                if (votes[i] != -1 && votes[i] < minVote) {
                    minVote = votes[i];
                    minVotes.clear();
                    minVotes.add(i);
                }
                if (votes[i] >= (n + 1) / 2) {
                    elects.add(i);
                }
            }

            System.out.println(Arrays.toString(minVotes.toArray()));

            if (!elects.isEmpty()) {
                int max = Integer.MIN_VALUE;
                for (int e : elects) {
                    max = Math.max(max, e);
                }
                answer[0] = cnt;
                answer[1] = max;
                break;
            }

            int min = Integer.MAX_VALUE;
            for (int mv : minVotes) {
                min = Math.min(min, mv);
            }
            votes[min] = -1;

            for (int i = 0; i < n; i++) {
                if (votes[i] != -1) {
                    votes[i] = 0;
                }
            }
        }

        return answer;
    }
}

package kimtaeone.greedy;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
class Income {
    private int day;
    private int fee;

    public Income(int fee, int day) {
        this.day = day;
        this.fee = fee;
    }

    public int getDay() {
        return day;
    }

    public int getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return "{day: " + this.day + ", fee: " + this.fee + "}";
    }
}
public class MaximumIncome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] incomes = new int[n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                incomes[i][j] = sc.nextInt();
            }
        }

        solution(incomes);
    }

    private static void solution(int[][] incomes) {
        int n = incomes.length;

        Queue<Income> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.getFee() == o2.getFee()) {
                return o1.getDay() - o2.getDay();
            }
            return o2.getFee() - o1.getFee();
        });

        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            if (incomes[i][1] > maxDay) {
                maxDay = incomes[i][1];
            }
        }

        int result = 0;
        while (maxDay > 0) {
            for (int i = 0; i < n; i++) {
                if (incomes[i][1] == maxDay) {
                    pq.offer(new Income(incomes[i][0], incomes[i][1]));
                }
            }

            if (!pq.isEmpty()) {
                Income poll = pq.poll();
                result += poll.getFee();
            }
            maxDay--;
        }

        System.out.println(result);
    }
}

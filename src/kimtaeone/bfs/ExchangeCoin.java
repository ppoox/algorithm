package kimtaeone.bfs;

import java.util.*;

public class ExchangeCoin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        solution(Arrays.stream(coins).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray(), m);
    }

    private static void solution(int[] coins, int m) {
        int n = coins.length;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Queue<Integer> queue = new LinkedList<>();
            int[] check = new int[n];
            int d = 0;
            int sum = 0;
            int cnt = 0;

            queue.offer(coins[i]);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int poll = queue.poll();
                    sum += poll;
                    cnt++;
                    System.out.println(sum + " : " + cnt);
                    if (sum > m) {
                        break;
                    }
                    if (cnt > answer) {
                        break;
                    }
                    if (sum == m) {
                        answer = Math.min(answer, cnt);
                    }

                    for (int k = 0; k < n; k++) {
                        queue.offer(coins[k]);
                    }
                }
                d++;
            }

            if (d >= 100) break;
        }


        System.out.println(answer);
    }

}

class Main {
    public int BFS(int target, int typesOfCoin, int[] coins, int[] check) {
        Queue<Integer> q = new LinkedList<>();
        check[target] = 1;
        q.offer(target);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int exchange = q.poll();
                for (int j = 0; j < typesOfCoin; j++) {
                    int nextExchange = exchange - coins[j];
                    if (nextExchange > 0 && check[nextExchange] == 0) {
                        check[nextExchange] = 1;
                        q.offer(nextExchange);
                    } else if (nextExchange == 0) return (level + 1);
                }
            }
            level++;
        }
        return (-1);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner in = new Scanner(System.in);
        int typesOfCoin = in.nextInt();
        int[] coins = new int[typesOfCoin];
        for (int i = 0; i < typesOfCoin; i++) coins[i] = in.nextInt();
        int target = in.nextInt();
        int[] check = new int[target + 1];
        System.out.println(T.BFS(target, typesOfCoin, coins, check));
        return;
    }
}
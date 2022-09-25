package kimtaeone.queue;

import java.util.*;

public class EmergencyRoom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        solution(m, list);
    }

    private static void solution(int m, int[] list) {
        Queue<Map<String, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < list.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            map.put("no", i);
            map.put("risk", list[i]);
            queue.offer(map);
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            Map<String, Integer> poll = queue.poll();
            boolean isContainEmergency = false;
            for (Map<String, Integer> q : queue) {
                if (q.get("risk") > poll.get("risk")) {
                    isContainEmergency = true;
                }
            }
            if (isContainEmergency) {
                queue.offer(poll);
            } else {
                cnt++;
                if (m == poll.get("no")) {
                    System.out.println(cnt);
                    break;
                }
            }
        }
    }
}

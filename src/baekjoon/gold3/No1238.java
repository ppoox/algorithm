package baekjoon.gold3;

import java.lang.reflect.Array;
import java.util.*;

public class No1238 {
    static class Road implements Comparable<Road> {
        private int start;
        private int end;
        private int time;
        public Road(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Road{" +
                    "start=" + start +
                    ", end=" + end +
                    ", time=" + time +
                    '}';
        }

        @Override
        public int compareTo(Road o) {
            return time - o.time;
        }
    }
    static int N = 0;
    static int M = 0;
    static int X = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();
        int[][] roots = new int[M][3];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                roots[i][j] = sc.nextInt();
            }
        }

        List<List<Road>> adjList = new ArrayList<>();
        List<List<Road>> reverse_adjList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
            reverse_adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            adjList.get(roots[i][0]).add(new Road(roots[i][0], roots[i][1], roots[i][2]));
            reverse_adjList.get(roots[i][1]).add(new Road(roots[i][1], roots[i][0], roots[i][2]));
        }

        int[] goDistance = dijkstra(adjList);
        int[] backDistance = dijkstra(reverse_adjList);

        int answer = 0;
        for (int i = 1; i < N + 1; i++) {
            answer = Math.max(answer, goDistance[i] + backDistance[i]);
        }

        System.out.println(answer);
    }

    public static int[] dijkstra(List<List<Road>> adjList) {
        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.offer(new Road(0, X, 0));

        boolean[] visited = new boolean[N + 1];
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = -1;
        distance[X] = 0;

        while (!pq.isEmpty()) {
            Road currentRoad = pq.poll();
            int curEnd = currentRoad.end;

            if (!visited[curEnd]) {
                visited[curEnd] = true;

                for (Road road : adjList.get(curEnd)) {
                    if (!visited[road.end] && distance[road.end] > distance[curEnd] + road.time) {
                        distance[road.end] = distance[curEnd] + road.time;
                        pq.add(new Road(0, road.end, distance[road.end]));
                    }
                }
            }
        }

        return distance;
    }
}

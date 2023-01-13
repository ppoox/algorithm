package baekjoon.gold4;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No14502 {
    static class Pointer {
        private int x;
        private int y;

        public Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pointer{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] lab = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                lab[i][j] = sc.nextInt();
            }
        }

        makeWall(lab, 0);

        System.out.println(answer);
    }

    public static void makeWall(int[][] lab, int walls) {
        if (walls >= 3) {
            spread(lab);
            return;
        }

        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[0].length; j++) {
                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    makeWall(lab,walls + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    public static void spread(int[][] lab) {
        int n = lab.length;
        int m = lab[0].length;
        int[][] copyLab = new int[n][m];
        Queue<Pointer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copyLab[i][j] = lab[i][j];
                if (lab[i][j] == 2) {
                    queue.offer(new Pointer(j, i));
                }
            }
        }

        for (Pointer p : queue) {
            System.out.println(p.toString());
        }

        while (!queue.isEmpty()) {
            Pointer poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int my = poll.y + dy[i];
                if (nx >= 0 && my >= 0 && nx < n && my < m && copyLab[my][nx] == 0) {
                    copyLab[my][nx] = 2;
                    queue.offer(new Pointer(nx, my));
                }
            }

            for (int[] l : copyLab) {
                System.out.println(Arrays.toString(l));
            }
            System.out.println("========================");
        }



        answer = Math.max(answer, countSafeArea(copyLab));
    }

    public static int countSafeArea(int[][] lab) {
        int cnt = 0;
        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[0].length; j++) {
                if (lab[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

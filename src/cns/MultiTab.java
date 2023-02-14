package cns;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MultiTab {
    public static void main(String[] args) {
//        solution(300,
//                new int[]{2000, 1000, 3000, 200, 600, 500},
//                new int[][]{
//                        {2, 3, -1, -1, -1},
//                        {4, 0, -1, -1, 6},
//                        {5, 0, 0, 0, 0},
//                        {-1, 0, 0, 0, 0},
//                        {-1, -1, -1, -1, -1},
//                        {-1, -1, 0, 0, 0}
//                });

        solution(
                120,
                new int[]{1500, 300, 250, 359, 600},
                new int[][]{
                        {2, 3, 4, 0, -1},
                        {0, 0, 0, 0, 0},
                        {-1, -1, -1, 0, 0},
                        {0, 0, 5, 0, 0},
                        {-1, 0, 0, -1, -1}}
        );
    }

    public static int solution(int k, int[] limits, int[][] sockets) {
        int answer = 0;
        int[] watts = new int[sockets.length];

//        outer:
//        for (int i = 0; i < sockets.length; i++) {
//            int watt = 0;
//            for (int j = 0; j < sockets[i].length; j++) {
//                if (sockets[i][j] >= 2) {
//                    continue outer;
//                } else if (sockets[i][j] == -1) {
//                    if (watt + k > limits[i]) {
//                        sockets[i][j] = 0;
//                        answer++;
//                    } else {
//                        watt += k;
//                    }
//                }
//            }
//
//            watts[i] = watt;
//        }


        for (int i = sockets.length - 1; i >= 0; i--) {
            int watt = 0;
            for (int j = 0; j < sockets[i].length; j++) {
                if (sockets[i][j] >= 2) {
                    if (watt + watts[sockets[i][j] - 1] > limits[i]) {
                        while (watt + watts[sockets[i][j] - 1] > limits[i]) {

                            watts[sockets[i][j] - 1] -= k;
                            answer++;
                        }
                    } else {
                        watt += watts[sockets[i][j] - 1];
                    }
                } else if (sockets[i][j] == -1) {
                    if (watt + k > limits[i]) {
                        sockets[i][j] = 0;
                        answer++;
                    } else {
                        watt += k;
                    }
                }
                if (i == 4) {

                    System.out.println(j + " : " + watt);
                }
            }

            watts[i] = watt;
        }

        System.out.println(Arrays.toString(watts));

//        for (int i = watts.length - 1; i >= 0; i--) {
//            if (watts[i] == 0) {
//                int watt = 0;
//                for (int j = 0; j < sockets[i].length; j++) {
//                    if (sockets[i][j] >= 2) {
//                        watt += watts[sockets[i][j] - 1];
//                    } else if (sockets[i][j] == -1) {
//                        if (watt + k > limits[i]) {
//                            sockets[i][j] = 0;
//                            answer++;
//                        } else {
//                            watt += k;
//                        }
//                    }
//                }
//                watts[i] = watt;
//            }
//        }
//
//        System.out.println(Arrays.toString(watts));
        System.out.println(answer);


        return answer;
    }
}

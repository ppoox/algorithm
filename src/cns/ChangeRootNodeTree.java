package cns;

import java.util.Arrays;

public class ChangeRootNodeTree {
    public static void main(String[] args) {
        new ChangeRootNodeTree().solution(
                new int[][]{{1, 3}, {1, 2}, {2, 4}, {2, 5}}, new int[]{2, 3}
        );
    }

    public int[] solution(int[][] edges, int[] roots) {
        int[] answer = {};
        int[][] ee = new int[edges.length][edges.length];


        for (int[] e : edges) {
            ee[e[0]-1][e[1]-1] = 1;
        }
        for (int[] e : ee) {
            System.out.println(Arrays.toString(e));
        }

        return answer;
    }
}

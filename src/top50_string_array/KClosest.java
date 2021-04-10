package top50_string_array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest {

    public static void main(String[] args) {
        KClosest a = new KClosest();
        int[][] points = { { 1, 3 }, { -2, 2 } };
        System.out.println("=!!!");
//        a.print(points);
        int k = 1;
////		int[][] points = {{3,3},{5,-1},{-2,4}};
////		int k =2;
//        System.out.println("===result==");
        int[][] result = a.solve(points, k);

        for(int[] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }

    public int[][] solve(int[][] points, int k) {

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));
        int[][] result = new int[k][2];

        for(int[] p : points) {
            pq.offer(p);
        }
        int index = 0;
        while(index < k) {
            result[index] = pq.poll();
            index++;
        }

        return result;
    }
}

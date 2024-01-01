package baekjoon.bronze1;

import java.io.*;
import java.util.Arrays;

public class No10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int i = 0; i < N; i++) {
//            pq.offer(Integer.parseInt(br.readLine()));
//        }
//        while (!pq.isEmpty()) {
//            bw.write(pq.poll() + "\n");
//        }

        int[] inputs = new int[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(inputs);

        for (int i = 0; i < N; i++) {
            bw.write(inputs[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}

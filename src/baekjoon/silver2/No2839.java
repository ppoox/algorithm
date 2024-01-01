package baekjoon.silver2;

import java.io.*;

public class No2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (N >= 3) {
            if (N % 5 == 0) {
                cnt += N / 5;
                N = 0;
                break;
            }
            N -= 3;
            cnt++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write((N == 0 ? cnt : -1) + "");
        bw.flush();
        bw.close();
    }
}

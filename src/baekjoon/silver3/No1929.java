package baekjoon.silver3;

import java.io.*;

public class No1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        int[] numbers = new int[M + 1];

        initializeNumbers(numbers);
        eraseMultipleOfPrime(numbers);

        for (int i = N; i <= M; i++) {
            if (numbers[i] != 0) {
                bw.write(numbers[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void initializeNumbers(int[] numbers) {
        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = i;
        }
    }

    public static void eraseMultipleOfPrime(int[] numbers) {
        for (int i = 2; i < (int) Math.sqrt(numbers.length) + 1; i++) {
            if (isPrimeNumber(i)) {
                int j = 2;
                while (i * j < numbers.length) {
                    numbers[i * j] = 0;
                    j++;
                }
            }
        }
    }

    public static boolean isPrimeNumber(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

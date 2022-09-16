package kimtaeone.array;

import java.util.Scanner;

public class PrintWinner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }

        solution(A, B);
    }

    private static void solution(int[] A, int[] B) {
        for (int i = 0; i < A.length; i++) {
            String winner = "";
            if (A[i] == B[i]) {
                winner = "D";
            } else if (A[i] == 1) {
                if (B[i] == 2) {
                    winner = "B";
                } else if (B[i] == 3) {
                    winner = "A";
                }
            } else if (A[i] == 2) {
                if (B[i] == 3) {
                    winner = "B";
                } else if (B[i] == 1) {
                    winner = "A";
                }
            } else if (A[i] == 3) {
                if (B[i] == 1) {
                    winner = "B";
                } else if (B[i] == 2) {
                    winner = "A";
                }
            }

            System.out.println(winner);
        }
    }
}

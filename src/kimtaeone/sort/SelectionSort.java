package kimtaeone.sort;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ns = new int[n];
        for (int i = 0; i < n; i++) {
            ns[i] = sc.nextInt();
        }

        solution(ns);
    }

    private static void solution(int[] ns) {

        for (int i = 0; i < ns.length; i++) {
            int min = ns[i];
            int minIdx = i;
            for (int j = i; j < ns.length; j++) {
                if (ns[j] < min) {
                    min = ns[j];
                    minIdx = j;
                }
            }
            int temp = ns[i];
            ns[i] = ns[minIdx];
            ns[minIdx] = temp;
        }

        for (int n : ns) {
            System.out.println(n + " ");
        }
    }
}

package baekjoon;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int max = scan.nextInt();
        int[] ns = new int[n];
        for(int i=0; i<n; i++) {
            ns[i] = scan.nextInt();
        }

        int result = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) continue;
                int sumIJ = ns[i];
                sumIJ += ns[j];

                for(int x=0; x<n; x++) {
                    if(i == x || j == x) continue;
                    int sumX = sumIJ;
                    sumX += ns[x];
                    System.out.println("sum X " + sumX);
                    if(sumX <= max && sumX > result) {
                        result = sumX;
                    }
                }
            }
        }
        System.out.println(result);
    }
}

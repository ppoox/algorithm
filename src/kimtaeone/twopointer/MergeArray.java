package kimtaeone.twopointer;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
//        3
//        1 3 5
//        5
//        2 3 6 7 9

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ns = new int[n];
        for (int i=0; i<n; i++) {
            ns[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] ms = new int[m];
        for (int i = 0; i < m; i++) {
            ms[i] = sc.nextInt();
        }

        solution(ns, ms);

    }

    private static void solution(int[] ns, int[] ms) {

        int[] merge = new int[ns.length + ms.length];
        int nIdx = 0, mIdx = 0, merIdx = 0;

        while (nIdx < ns.length || mIdx < ms.length) {
            if (nIdx < ns.length && mIdx >= ms.length) {
                merge[merIdx++] = ns[nIdx++];
            } else if (nIdx >= ns.length && mIdx < ms.length) {
                merge[merIdx++] = ms[mIdx++];
            } else if (ns[nIdx] <= ms[mIdx]) {
                merge[merIdx++] = ns[nIdx++];
            } else if (ns[nIdx] > ms[mIdx]){
                merge[merIdx++] = ms[mIdx++];
            }
        }

        for (int m : merge) {
            System.out.print(m + " ");
        }
    }
}

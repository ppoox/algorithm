package kimtaeone.twopointer;

import java.util.Scanner;

public class MaxLengthConsecutiveSubsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] seq = new int[n];

        for (int i = 0; i < n; i++) {
            seq[i] = sc.nextInt();
        }

        solution(seq, k);
    }

    private static void solution(int[] seq, int k) {
        int lt = 0;
        int max = 0;
        int cnt = 0;
        for (int rt = 0; rt < seq.length; rt++) {
            if (seq[rt] == 0) {
                cnt++;
            }
            System.out.println("rt: " + rt + " lt: " + lt + " cnt: " + cnt);
            if (cnt > k) {
                while (lt < rt) {
                    if (seq[++lt] == 0) {
                        cnt--;
                        break;
                    }
                }
            }
            System.out.println(max + " : " + (rt-lt));

            max = Math.max(max, rt - lt);
        }

        System.out.println(max);
    }
}

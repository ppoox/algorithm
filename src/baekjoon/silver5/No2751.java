package baekjoon.silver5;

import java.util.Arrays;
import java.util.Scanner;

public class No2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        int max = Arrays.stream(nums).max().getAsInt();
        int[] cnts = new int[max + 1];
        for (int i = 0; i < N; i++) {
            if (nums[i] < 0) {
                cnts[-nums[i]] += 2;
            } else {
                cnts[nums[i]] += 1;
            }
        }

        for (int i = max; i >= 0; i--) {
            if (cnts[i] == 3 || cnts[i] == 2) {
                System.out.println(i * -1);
                cnts[i] -= 2;
            }
        }
        for (int i = 0; i <= max; i++) {
            if (cnts[i] == 1) {
                System.out.println(i);
            }
        }
    }
}

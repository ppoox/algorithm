package kimtaeone.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Mischief {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        solution(nums);
    }

    private static void solution(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);

        int[] answer = new int[2];
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != temp[i]) {
                answer[cnt++] = i + 1;
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}

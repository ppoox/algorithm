package kimtaeone.array;

import java.util.Scanner;

public class GetGrade {
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
        for (int i = 0; i < nums.length; i++) {
            int grade = 1;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    grade++;
                }
            }

            System.out.print(grade + " ");
        }
    }
}

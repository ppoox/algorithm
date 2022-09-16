package kimtaeone.array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FibonacciNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        solution(n);
    }

    private static void solution(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < n; i++) {
            nums[i] = nums[i - 2] + nums[i - 1];
        }

        System.out.println(Arrays.stream(nums).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
    }
}

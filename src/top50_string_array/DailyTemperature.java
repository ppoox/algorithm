package top50_string_array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = solve(nums);

        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] solve(int[] temper) {
        // 1.ds stack
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temper.length];

        // 2. for, while
        for (int i=0; i<temper.length; i++) {
            while (!stack.isEmpty() && temper[stack.peek()]  < temper[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }

            stack.push(i);
        }

        return result;
    }
}

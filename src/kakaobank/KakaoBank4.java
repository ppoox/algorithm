package kakaobank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class KakaoBank4 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 3, 3, 2, 2, 4, 5, 1, 1, 1, 3, 3, 3}));  // 6
        System.out.println(solution(new int[]{1,2,3}));  // 3
        System.out.println(solution(new int[]{2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 1, 2}));  // 5
        System.out.println(solution(new int[]{1,1,1,1,1,1,1,1,1,2}));  // 1
    }

    public static int solution(int[] arr) {
        int answer = 0;

        List<Integer> oldList = Arrays.stream(arr).boxed().collect(Collectors.toList());

        while(true) {
            answer++;
            oldList = countDistinctContinuous(oldList);
            if(oldList.size() <= 1 && oldList.stream().reduce(0, Integer::sum) <= 1) {
                break;
            }
        }

        return answer;
    }

    public static List<Integer> countDistinctContinuous(List<Integer> arr) {

        List<Integer> newList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        int count = 0;
        for(int i=0; i<arr.size(); i++) {
            if(i == 0) {
                count++;
                stack.push(arr.get(i));
                continue;
            }

            int prev = stack.pop();

            if(prev == arr.get(i)) {
                count++;
                stack.push(prev);
            }

            if(prev != arr.get(i)) {
                newList.add(count);
                count = 1;
                stack.push(arr.get(i));
            }

            if(i == arr.size() - 1) {
                newList.add(count);
            }
        }

        return newList;
    }
}

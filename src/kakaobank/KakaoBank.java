package kakaobank;

import java.util.Stack;
import java.util.regex.Pattern;

public class KakaoBank {

    public static void main(String[] args) {
//        System.out.println(solution(new String[]{"12","2","5","+","*","9"," 3","/","-"}));   // 84
//        System.out.println(solution(new String[]{"1","1","+","1","1","+","*"}));   // 4
        System.out.println(solution(new String[]{"0", "5", "1", "+", "*"}));   // 4
    }

    public static long solution(String[] p) {
        int answer = 0;
        String regNum = "[0-9]*$";

        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for(String s : p) {
            count++;
            if(Pattern.matches(regNum, s)) {
                stack.push(Integer.parseInt(s));
                continue;
            }

            if(stack.empty()) {
                continue;
            }
            int n2 = (int) stack.pop();
            int n1 = (int) stack.pop();
            long cal = 0;

            if("+".equals(s)) {
                cal = n1 + n2;
            }
            if("-".equals(s)) {
                cal = n1 - n2;
            }
            if("*".equals(s)) {
                cal = n1 * n2;
            }
            if("/".equals(s)) {
                cal = n1 / n2;
            }

            if(count >= p.length) {
                answer = Long.valueOf(cal).intValue();
                break;
            }

            stack.push(Long.valueOf(cal).intValue());
        }

        return answer;
    }
}

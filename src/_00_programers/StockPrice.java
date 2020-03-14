package _00_programers;

public class StockPrice {
    public static void main(String[] args) {
        //solution(new int[]{1,2,3,2,3});
        solution(new int[]{5,2,1,3,3});
        // [1, 1, 2, 1, 0]
    }

    public static int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];

        for(int i=0; i<length; i++) {
            for(int j=i; j<length; j++) {
                if(prices[i] > prices[j]) {
                    answer[i] = j-i;
                    break;
                }
            }

            if(answer[i] == 0 && i != length-1) {
                answer[i] = length-i-1;
            }
        }

        return answer;
    }
}

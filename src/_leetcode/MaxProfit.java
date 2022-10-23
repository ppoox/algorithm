package _leetcode;

public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public static int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur + prices[i] - prices[i-1]);
            System.out.println(":: maxCur " + maxCur + " / maxSoFar " + maxSoFar);
            maxSoFar = Math.max(maxCur, maxSoFar);
            System.out.println(":: maxSoFar " + maxSoFar);
        }

        return maxSoFar;
    }

}

package leetcode;

import java.util.Arrays;
import java.util.List;

public class StoneGame {
    public static void main(String[] args) {
        stoneGame(new int[]{3, 7, 2, 3});
    }

    public static boolean stoneGame(int[] p) {
        int[] dp = Arrays.copyOf(p, p.length);
        System.out.println(Arrays.toString(dp));
        System.out.println("----------------------------------------------------------");
        for (int d = 1; d < p.length; d++)
            for (int i = 0; i < p.length - d; i++) {
                System.out.println("p["+i+"] : "+p[i]+" / dp["+i+"+1] : "+dp[i+1]+" / minus : "+(p[i]-dp[i+1]));
                System.out.println("p["+i+"+"+d+"] : "+p[i+d]+" / dp["+i+"] : "+dp[i]+" / minus : "+(p[i+d]-dp[i]));
                System.out.println("----------------------------------------------------------");
                dp[i] = Math.max(p[i] - dp[i + 1], p[i + d] - dp[i]);
            }
        return dp[0] > 0;
//
//        List<Integer> pileList = Arrays.stream(piles).boxed().collect(Collectors.toList());
//        List<Integer> alice = new ArrayList<>();
//        List<Integer> bob = new ArrayList<>();
//
//        chooseStone(pileList, alice, bob, true);
//
//        return alice.stream().mapToInt(i -> i).sum() >
//                bob.stream().mapToInt(i -> i).sum();
    }

    public static void chooseStone(List<Integer> piles, List<Integer> alice, List<Integer> bob, boolean isAliceTurn) {
        if (piles.isEmpty()) {
            return;
        }

        if (isAliceTurn) {
            alice.add(getPile(piles, 0, piles.size()-1));
            chooseStone(piles, alice, bob, false);
        } else {
            bob.add(getPile(piles, 0, piles.size()-1));
            chooseStone(piles, alice, bob, true);
        }
    }

    public static int getPile(List<Integer> piles, int first, int last) {
//        if (first > piles.size() || last < piles.size()) {
//            return 0;
//        }
        int pile = 0;

        if (piles.get(first) == piles.get(last)) {
            System.out.println(first + " / " + last + " / " + Arrays.toString(piles.toArray()));
            pile = getPile(piles, first+1, last-1);
        } else if (piles.get(first) > piles.get(last)) {
            pile = piles.get(first);
            piles.remove(first);
        } else {
            pile = piles.get(last);
            piles.remove(last);
        }

        return pile;
}
    }

package _leetcode;

import java.util.Arrays;

public class FindTheTownJudge {
    public static void main(String[] args) {
//        Example 1:
//
//        Input: n = 2, trust = [[1,2]]
//        Output: 2
//        Example 2:
//
//        Input: n = 3, trust = [[1,3],[2,3]]
//        Output: 3
//        Example 3:
//
//        Input: n = 3, trust = [[1,3],[2,3],[3,1]]
//        Output: -1
//        Example 4:
//
//        Input: n = 3, trust = [[1,2],[2,3]]
//        Output: -1
//        Example 5:
//
//        Input: n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
//        Output: 3

//        findJudge(2, new int[][]{{1, 2}});
//        findJudge(3, new int[][]{{1, 3}, {2, 3}}); // 3
//        findJudge(3, new int[][]{{1, 3}, {2, 3}, {3,1}}); // -1
        findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}); // 3
    }

    public static int findJudge(int n, int[][] trust) {
        int[] result = new int[n];

        for (int i = 0; i < trust.length; i++) {
            result[trust[i][1] - 1]++;
        }

        Arrays.stream(result).forEach(System.out::println);

        System.out.println("결과 " + Arrays.stream(result)
                .filter(label -> label == -1)
                .filter(guessJudgeLabel ->
                        Arrays.stream(trust)
                                .map(t -> t[0])
                                .peek(y -> System.out.println(">> " + y + " / " + guessJudgeLabel))
                                .noneMatch(trustLabel -> trustLabel == guessJudgeLabel))
                .findAny()
                .orElse(-2)+1);

        return Arrays.stream(result)
                .map(idx -> idx + 1)
                .filter(label -> label == n)
                .filter(guessJudgeLabel ->
                        Arrays.stream(trust)
                                .map(t -> t[0])
                                .noneMatch(trustLabel -> trustLabel == guessJudgeLabel))
                .findAny()
                .orElse(-1);
    }
}

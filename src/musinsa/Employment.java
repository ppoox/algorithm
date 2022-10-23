package musinsa;

public class Employment {

    public static void main(String[] args) {
        String[] scores = {"AAFAFA", "FEECAA", "FABBCB", "CBEDEE", "CCCCCC"};
        String[] scores2 = {"BCD","ABB","FEE"};

        new Employment().solution(scores);
        new Employment().solution(scores2);
    }

    public int solution(String[] scores) {
        int passCnt = 0;
        for (int i = 0; i < scores.length; i++) {
            if (isPass(convertToScoreCntArray(scores[i]), scores[i].length())) {
                passCnt++;
            }

        }
        System.out.println(passCnt);
        return passCnt;
    }

    public boolean isPass(int[] scoreCntArray, int volunteerCnt) {
        if (scoreCntArray[0] >= 2) {
            return false;
        } else if (scoreCntArray[5] >= 2) {
            return true;
        } else {
            int sum = 0;
            int max = 0;
            int min = 5;
            for (int i = 0; i < scoreCntArray.length; i++) {
                sum += scoreCntArray[i] * i;
                if (scoreCntArray[i] > 0) {
                    if (i > max) {
                        max = i;
                    }
                    if (i < min) {
                        min = i;
                    }
                }
            }
            return (sum - max - min) / (volunteerCnt - 2) >= 3;
        }
    }

    public int[] convertToScoreCntArray(String score) {
        int[] scoreCntArray = new int[6];
        for (char sc : score.toCharArray()) {
            if (sc == 'A') {
                scoreCntArray[5] += 1;
            } else if (sc == 'B') {
                scoreCntArray[4] += 1;
            } else if (sc == 'C') {
                scoreCntArray[3] += 1;
            } else if (sc == 'D') {
                scoreCntArray[2] += 1;
            } else if (sc == 'E') {
                scoreCntArray[1] += 1;
            } else if (sc == 'F') {
                scoreCntArray[0] += 1;
            }
        }
        return scoreCntArray;
    }

}

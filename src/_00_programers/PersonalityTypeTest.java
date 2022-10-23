package _00_programers;

public class PersonalityTypeTest {

    public static void main(String[] args) {
        String[] survey1 = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choice1 = {5, 3, 2, 7, 5};
        System.out.println(new PersonalityTypeTest().solution(survey1, choice1));


//        choices	뜻
//        1	매우 비동의
//        2	비동의
//        3	약간 비동의
//        4	모르겠음
//        5	약간 동의
//        6	동의
//        7	매우 동의
    }

    public String solution(String[] survey, int[] choices) {
        StringBuilder typeBuilder = new StringBuilder();

        int[][] statistics = new int[4][2];
        for (int i=0; i< survey.length; i++) {
            int choice = choices[i];

            // survey char1=비동의, char2=동의
            if (choice > 4) {   // 동의
                setScore(statistics, survey[i].charAt(1), choice - 4);
            } else if (choice < 4) {    // 비동의
                setScore(statistics, survey[i].charAt(0), (choice * -1) + 4);
            }
        }

        typeBuilder.append(statistics[0][0] >= statistics[0][1] ? 'R' : 'T');
        typeBuilder.append(statistics[1][0] >= statistics[1][1] ? 'C' : 'F');
        typeBuilder.append(statistics[2][0] >= statistics[2][1] ? 'J' : 'M');
        typeBuilder.append(statistics[3][0] >= statistics[3][1] ? 'A' : 'N');

        return typeBuilder.toString();
    }

    public static void setScore(int[][] statistics, char s, int score) {
//        1번 지표	라이언형(R), 튜브형(T)
//        2번 지표	콘형(C), 프로도형(F)
//        3번 지표	제이지형(J), 무지형(M)
//        4번 지표	어피치형(A), 네오형(N)
        switch (s) {
            case 'R':
                statistics[0][0] += score;
                break;
            case 'T':
                statistics[0][1] += score;
                break;
            case 'C':
                statistics[1][0] += score;
                break;
            case 'F':
                statistics[1][1] += score;
                break;
            case 'J':
                statistics[2][0] += score;
                break;
            case 'M':
                statistics[2][1] += score;
                break;
            case 'A':
                statistics[3][0] += score;
                break;
            case 'N':
                statistics[3][1] += score;
                break;
        }
    }
}

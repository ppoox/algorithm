package kakaobank;

public class KakaoBank5 {
    public static void main(String[] args) {
        System.out.println(solution("onesevenfive")); // 175
        System.out.println(solution("threetwo")); // 32
        System.out.println(solution("fourthreenine")); // 439
        System.out.println(solution("eight")); // 8
        System.out.println(solution("fivetwoonetwo")); // 5212
        System.out.println(solution("zerosix")); // 06
    }

    public static String solution(String number) {
        String answer = "";
        String[] numberWord = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        while(!"".equals(number)) {
            for(int i=0; i<numberWord.length; i++) {
                if(number.indexOf(numberWord[i]) == 0) {
                    answer += Integer.toString(i);

                    number = number.substring(numberWord[i].length());
                }
            }
        }

        return answer;
    }
}

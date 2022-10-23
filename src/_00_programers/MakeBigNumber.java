package _00_programers;

public class MakeBigNumber {
    public static void main(String[] args) {
        new MakeBigNumber().solution("4177252841", 4);
    }

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;
            for (int j = idx; j <= i+k; j++) {
//                max = Math.max(max, number.charAt(j) - '0');
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    idx = j+1;
                }
                System.out.println(" / i: " + i + " / j: " + j + " / idx: " + idx + " / num: " + number.charAt(j) + " max: " + max + " / sb: " + sb);
//                idx = j+1;
            }
            sb.append(max);
        }

        System.out.println(sb.toString());
        return "";
    }

}

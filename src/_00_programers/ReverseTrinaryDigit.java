package _00_programers;

public class ReverseTrinaryDigit {

    public static void main(String[] args) {
        new ReverseTrinaryDigit().solution(45);
    }

    public int solution(int n) {
        int answer = 0;

        StringBuilder trinaryBuilder = new StringBuilder();
        while (n >= 3) {
            trinaryBuilder.append(n % 3);
            n /= 3;
        }
        trinaryBuilder.append(n);

        long num = Long.valueOf(trinaryBuilder.toString());
        int cnt = 0;
        while (num > 0) {
            answer += (num % 10) * (int) Math.pow(3, cnt++);
            System.out.println(answer + " . " + num);
            num /= 10;
        }

        System.out.println(answer);

        return answer;
    }
}

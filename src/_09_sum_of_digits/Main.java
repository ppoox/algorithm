package _09_sum_of_digits;

public class Main {
    public static void main(String[] args) {
        int num = 1242;

        int a = 10;
        int result = 0;
        while (num >= 1) {
            result += num % a;
            num /= 10;

        }

            System.out.println(result);
    }
}

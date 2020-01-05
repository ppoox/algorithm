package _08_factorial;

public class Main {
    public static void main(String[] args) {
        int lastNum = 4;
        int result = 1;

        for(int i=1; i<=lastNum; i++) {
            result *= i;
        }

        System.out.println(result);

    }
}

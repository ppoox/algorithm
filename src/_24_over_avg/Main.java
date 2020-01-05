package _24_over_avg;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] arr = {100, 95, 90, 80, 70, 60, 50};

        int sum = 0;
        for(int num : arr) {
            sum += num;
        }
        double avg = (double)sum/arr.length;
        System.out.println("AVG : " + avg);

        sum = 0;
        for(int num : arr) {
            if(num > avg) {
                sum++;
            }
        }

        System.out.println("over per AVG : "+ (double)sum/arr.length*100);
    }
}

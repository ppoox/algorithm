package okky_question;

public class Main {

    public static void main(String[] args) {

        System.out.println("결과 : " + solution(52));
        //9, 55
        //        12, 233
        //        52, 316290802
    }

    public static int solution(int n) {
        int[] arr = new int[n];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for(int i=3; i<n; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }

        return (arr[n-2]+arr[n-1])%1000000007;
    }

}

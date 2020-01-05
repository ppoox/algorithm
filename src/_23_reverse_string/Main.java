package _23_reverse_string;

public class Main {
    public static void main(String[] args) {
        String str = "ADEFH";

        String[] arr = str.split("");
        for(int i=arr.length-1; i>-1; i--) {
            System.out.print(arr[i]);
        }
        System.out.println();

        char[] arr2 = str.toCharArray();
        char tmp;
        int len = arr2.length;
        for(int i=0; i<len/2; i++) {
            tmp = arr2[i];
            arr2[i] = arr2[len-i-1];
            arr2[len-i-1] = tmp;
        }

        System.out.println(new String(arr2));
    }
}

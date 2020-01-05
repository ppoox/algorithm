package _10_num_rec01;

public class Main {
    public static void main(String[] args) {
        int recSize = 4;

        int num = 1;
        for(int i=0; i<recSize; i++) {
            for(int j=0; j<recSize; j++) {
                System.out.printf("%4d", num);
                num++;
            }
            System.out.println();
        }
    }
}

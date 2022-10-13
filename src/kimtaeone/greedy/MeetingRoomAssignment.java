package kimtaeone.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MeetingRoomAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                meetings[i][j] = sc.nextInt();
            }
        }

        solution(meetings);
    }

    private static void solution(int[][] meetings) {

        Arrays.sort(meetings, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        for (int[] t : meetings) {
            System.out.println(Arrays.toString(t));
        }

        int cnt = 1;
        int prev = meetings[0][1];
        for (int j = 1; j < meetings.length; j++) {
            if (meetings[j][0] >= prev) {
                prev = meetings[j][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

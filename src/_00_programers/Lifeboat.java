package _00_programers;

import java.util.Arrays;

public class Lifeboat {
    /**
     * 구명보트 한번에 최대 2명
     * 무게 제한 존재
     */
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
//        int[] people = {160, 150, 140, 60, 50, 40};
//        int limit = 200;
        new Lifeboat().solution(people, limit);

    }

    public int solution(int[] people, int limit) {
        int boatCnt = 0;
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));

        int start = 0;
        int end = people.length-1;
        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start++;
            }
            end--;
            boatCnt++;
        }
        System.out.println(boatCnt);
        return boatCnt;
    }
}

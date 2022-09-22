package kimtaeone.hashmap;

import java.util.*;

public class TypeOfSales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] salesRecords = new int[n];
        for (int i = 0; i < n; i++) {
            salesRecords[i] = sc.nextInt();
        }

        solution(salesRecords, k);
    }

    private static void solution(int[] salesRecords, int k) {
        int n = salesRecords.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k - 1; i++) {
            map.put(salesRecords[i], map.getOrDefault(salesRecords[i], 0) + 1);
        }
        int lt = 0;
        for (int rt = k - 1; rt < n; rt++) {
            map.put(salesRecords[rt], map.getOrDefault(salesRecords[rt], 0) + 1);
            System.out.println(map.size() + " ");

            Integer orDefault = map.getOrDefault(salesRecords[lt], 0);
            if (orDefault <= 1) {
                map.remove(salesRecords[lt]);
            } else {
                map.put(salesRecords[lt], orDefault - 1);
            }
            lt++;
        }
    }
}

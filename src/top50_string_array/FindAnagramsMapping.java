package top50_string_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAnagramsMapping {

    public static void main(String[] args) {
        int[] a = new int[]{11, 27, 45, 31, 50};
        int[] b = new int[]{50, 11, 31, 45, 27};

        System.out.println(Arrays.toString(findAnagramsMapping(a, b)));
    }

    public static int[] findAnagramsMapping(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<a.length; i++) {
            map.put(b[i], i);
        }

        int[] result = new int[a.length];

        for(int i=0; i<a.length; i++) {
            result[i] = map.get(a[i]);
        }

        return result;
    }
}

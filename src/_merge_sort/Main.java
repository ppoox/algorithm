package _merge_sort;

import java.util.Arrays;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 4, 7, 9, 0};
        mergeSort(a, 0, a.length-1);

        System.out.println("result " + Arrays.toString(a));
    }

    public static void mergeSort(int[] a, int start, int end) {
        if(start < end) {
            int middle = (start+end)/2;
            mergeSort(a, start, middle);
            mergeSort(a, middle+1, end);
            System.out.println(start + " " + middle + " " + end);
            merge(a, start, middle, end);
        }
    }

    public static void merge(int[] a, int start, int middle, int end) {
        int i = start, j = middle + 1, k = start;
        int[] tmp = new int[a.length];

        while (i <= middle && j <= end) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        while (i <= middle) {
            tmp[k++] = a[i++];
        }
        while (j <= end) {
            tmp[k++] = a[j++];
        }

        System.out.println("tmp " + Arrays.toString(tmp));

        for (int z = start; z <= end; z++) {
            a[z] = tmp[z];
        }
    }
}
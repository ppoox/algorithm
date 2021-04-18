package top50_string_array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1,  2,  3,  4, 5},
                { 6,  7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        System.out.println(solve(matrix));
    }

    public static List<Integer> solve(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();

        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0;
        int colEnd = matrix[0].length-1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            // Right
            for (int i=colStart; i<=colEnd; i++) {
                resultList.add(matrix[rowStart][i]);
            }
            rowStart++;

            // Down
            for (int i=rowStart; i<=rowEnd; i++) {
                resultList.add(matrix[i][colEnd]);
            }
            colEnd--;

            // Left
            if(rowStart < rowEnd)
            for (int i=colEnd; i>=colStart; i--) {
                resultList.add(matrix[rowEnd][i]);
            }
            rowEnd--;

            // Up
            if(colStart <= colEnd-1)
            for (int i=rowEnd; i>=rowStart; i--) {
                resultList.add(matrix[i][colStart]);
            }
            colStart++;
        }
        return resultList;
    }
}

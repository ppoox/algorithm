package leetcode;

import java.util.Arrays;

public class CountNegatives {
    public static void main(String[] args) {
        System.out.println(countNegatives(new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}}));
        System.out.println(countNegatives(new int[][]{{3,2},{1,0}}));
        System.out.println(countNegatives(new int[][]{{1,-1},{-1,-1}}));

    }

    public static int countNegatives(int[][] grid) {
        int result = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] < 0) {
                    result += grid[i].length - j;
                    break;
                }
            }
        }

        return result;
    }
}

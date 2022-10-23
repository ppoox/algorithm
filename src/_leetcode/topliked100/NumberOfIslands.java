package _leetcode.topliked100;

import java.util.Arrays;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
//        char[][] grid = {
//                {'1'},
//                {'1'}
//        };
        new NumberOfIslands().numIslands(grid);
    }

    public int numIslands(char[][] grid) {
        for (char[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        int[] islands = findIslands(grid);
        int count = 0;
        while (islands[0] != -1 && islands[1] != -1) {
            System.out.println(Arrays.toString(islands));
            exploreIslands(grid, islands[0], islands[1]);
            islands = findIslands(grid);
            count++;
        }

        System.out.println(count);

        return count;
    }

    public void exploreIslands(char[][] grid, int startX, int startY) {
        int y = grid.length-1;
        int x = grid[0].length-1;
        if (startX < 0 || startX > x || startY < 0 || startY > y) {
            return;
        }
        if (grid[startY][startX] == '0' || grid[startY][startX] == '2') {
            return;
        }
        grid[startY][startX] = '2';
        exploreIslands(grid, startX-1, startY);
        exploreIslands(grid, startX, startY+1);
        exploreIslands(grid, startX+1, startY);
        exploreIslands(grid, startX, startY-1);
    }

    public int[] findIslands(char[][] grid) {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                int value = grid[y][x];
                if (value == '1') {
                    return new int[] {x, y};
                }
            }
        }

        return new int[]{-1, -1};
    }
}

package _2021_08_challenge.week1;

public class First {

    public static void main(String[] args) {
//        int[][] grid1 = {
//                {1, 0},
//                {0, 1}
//        };
//
//        System.out.println(largestIsland(grid1));
//
//        int[][] grid2 = {
//                {1, 1},
//                {0, 1}
//        };
//
//        System.out.println(largestIsland(grid2));
//
//        int[][] grid3 = {
//                {1, 1},
//                {1, 1}
//        };
//
//        System.out.println(largestIsland(grid3));

//        int[][] grid4 = {
//                {0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 1, 1, 1, 0, 0},
//                {0, 1, 0, 0, 1, 0, 0},
//                {1, 0, 1, 0, 1, 0, 0},
//                {0, 1, 0, 0, 1, 0, 0},
//                {0, 1, 0, 0, 1, 0, 0},
//                {0, 1, 1, 1, 1, 0, 0}
//        };
//
//        System.out.println(largestIsland(grid4));

        int[][] grid5 = {
                {1, 0, 1},
                {0, 0, 0},
                {0, 1, 1}
        };

        System.out.println(largestIsland(grid5));
    }

    public static int largestIsland(int[][] grid) {
        int result = 0;

        int n = grid.length;

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (grid[x][y] == 0) {
                    grid[x][y] = 1;
                    result = Math.max(calculateIslandSize(grid, new boolean[n][n], x, y, 0), result);
                    grid[x][y] = 0;
                }
            }
        }

        return result == 0 ? n * n : result;
    }

    public static int calculateIslandSize(int[][] grid, boolean[][] visited, int x, int y, int size) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid.length || grid[x][y] == 0 || visited[x][y]) {
            return size;
        }

        visited[x][y] = true;
        size++;

        size = calculateIslandSize(grid, visited, x - 1, y, size);
        size = calculateIslandSize(grid, visited,  x, y - 1, size);
        size = calculateIslandSize(grid, visited, x, y + 1, size);
        size = calculateIslandSize(grid, visited, x + 1, y, size);

        return size;
    }
}

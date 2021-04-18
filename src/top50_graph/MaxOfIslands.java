package top50_graph;

public class MaxOfIslands {
    private static int[][] dirs = {{-1,0}, {1,0}, {0, -1}, {0, 1}};
    private static int m;
    private static int n;

    public static void main(String[] args) {
        int[][] grid =
                {
                        {1,1,0,1,1},
                        {0,1,1,0,0},
                        {0,0,0,0,0},
                        {1,1,0,1,1},
                        {1,0,1,1,1},
                        {1,0,1,1,1}
                };

        System.out.println(solve(grid));
    }
    public static int solve(int[][] grid) {
        if (grid == null || grid.length < 1) {
            return 0;
        }

        int result = 0;
        m = grid.length;
        n = grid[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, 0);
                    result = Math.max(result, area);
                }
            }
        }

        return result;
    }

    public static int dfs(int[][] grid, int x, int y, int area) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
            return area;
        }

        grid[x][y] = 0;
        area++;

        for (int[] dir : dirs) {
            area = dfs(grid, x+dir[0], y+dir[1], area);
        }

        return area;
    }
}

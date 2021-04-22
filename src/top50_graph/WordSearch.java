package top50_graph;

public class WordSearch {
    public static void main(String[] args) {
        char[][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";

        System.out.println(solve(grid, word));
    }

    public static boolean solve(char[][] grid, String word) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(grid, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] grid, boolean[][] visited, int x, int y, int start, String word) {
        if (start == word.length()) {
            return true;
        }
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        if (grid[x][y] != word.charAt(start)) {
            return false;
        }

        visited[x][y] = true;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            if (dfs(grid, visited, x + dir[0], y + dir[1], start + 1, word)) {
                return true;
            }
        }

        visited[x][y] = false;

        return false;
    }
}

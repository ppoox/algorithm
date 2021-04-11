package top50_graph;

public class NumberOfIslandDFS {

    public static void main(String[] args) {
        char[][] grid= {
                {'1','1','1','0','1'},
                {'1','1','0','0','0'},
                {'1','1','0','0','1'},
                {'0','0','0','0','1'}
        };

        NumberOfIslandDFS dfs = new NumberOfIslandDFS();
        System.out.println(dfs.solve(grid));
    }

    public int solve(char[][] grid) {
        print(grid);

        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        print(grid);

        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
//        System.out.println(i + " / " + j);
        int m = grid.length;
        int n = grid[0].length;

        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] != '1') return;
        grid[i][j] = 'X';

        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i-1, j-1);
        dfs(grid, i-1, j+1);
    }

    public void print(char[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                System.out.print("grid["+i+"]["+j+"] " + grid[i][j] +" ");
            }
            System.out.println();
        }
    }
}

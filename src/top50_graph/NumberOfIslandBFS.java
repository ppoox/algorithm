package top50_graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandBFS {

    public static void main(String[] args) {
        char[][] grid= {
                {'1','1','1','0','1'},
                {'1','1','0','0','0'},
                {'0','0','0','0','1'},
                {'1','0','0','0','1'}
        };

        NumberOfIslandBFS bfs = new NumberOfIslandBFS();
        System.out.println(bfs.solve(grid));
    }

    public int solve(char[][] grid) {
        int count = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    System.out.println("!!");
                    grid[i][j] = '0';
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        for (char[] g : grid) {
            System.out.println("result " + Arrays.toString(g));
        }
        return count;
    }

    int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    public void bfs(char[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for(int[] dir : dirs) {
                int x1 = point[0] + dir[0];
                int y1 = point[1] + dir[1];

                if(x1 >= 0 && y1 >= 0 && x1 < grid.length && y1 < grid[0].length && grid[x1][y1] == '1') {
                    grid[x1][y1] = '0';
                    queue.offer(new int[] {x1, y1});

                    for (char[] g : grid) {
                        System.out.println(Arrays.toString(g));
                    }
                    System.out.println();
                }
            }
        }



    }
}

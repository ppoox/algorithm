package _dfs_bfs;

import java.util.LinkedList;

public class Dfs {
    public static void main(String[] args) {
        Integer[] list = new Integer[] {1,1,1,1,1};


        dfs(list, 0, 0, 0);
    }

    public static void dfs(Integer[] list, int start, int sum, int result) {
        LinkedList<Integer> q = new LinkedList<>();

        while (start < list.length) {
            q.add(list[start]);
            q.add(list[start]*-1);
            while (q.size() > 0) {
                sum+=q.poll();
                start++;
                if(start == list.length) {
                    if(sum == 3) {
                        result++;
                        System.out.println(sum);
                    }
                    sum=0;
                }
                dfs(list, start, sum, result);

            }

        }
    }



}

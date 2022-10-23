package _00_programers;

import java.util.Stack;

public class Network {

    public static void main(String[] args) {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        new Network().solution(3, computers);
    }

    public int solution(int n, int[][] computers) {
        Stack<Integer> stack = new Stack<>();

        while (!stack.isEmpty()) {
            for (int i = 0; i < n; i++) {


            }
        }

        return 0;
    }

    public void dfs() {

    }
}

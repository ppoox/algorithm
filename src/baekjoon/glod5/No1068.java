package baekjoon.glod5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No1068 {
    static int N;
    static int target, root;
    static List<List<Integer>> tree = new ArrayList<>();
    static int count;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] nodes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        target = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            if (nodes[i] == -1) {
                root = i;
                continue;
            }
            tree.get(nodes[i]).add(i);
        }
        br.close();
    }

    static void solve() {
        /**
         * 지우려는 대상 노드를 제거하고 DFS로 하위 노드들도 제거
         */
        for (List<Integer> t : tree) {
            if (t.contains(target)) {
                t.removeIf(it -> it == target);
                removeNode(target);
            }
        }
        /**
         * Tree를 순회하면서 리프노드 개수 카운팅
         */
        countLeafNode(root);
    }

    static void removeNode(int parentNode) {
        List<Integer> childNodes = tree.get(parentNode);
        for (int childNode : childNodes) {
            removeNode(childNode);
        }
        tree.set(parentNode, new ArrayList<>());
    }

    static void countLeafNode(int parentNode) {
        List<Integer> childNodes = tree.get(parentNode);
        for (int childNode : childNodes) {
            if (tree.get(childNode).isEmpty()) {
                count++;
                continue;
            }
            countLeafNode(childNode);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        if (target == root) {
            System.out.println(0);
        } else {
            solve();
            System.out.println(count == 0 ? 1 : count);
        }
    }
}

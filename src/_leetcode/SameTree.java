package _leetcode;

import leetcode.TreeNode;

import java.util.*;

public class SameTree {
    public static void main(String[] args) {
        TreeNode case1 = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        TreeNode case11 = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        TreeNode case2 = new TreeNode(1, new TreeNode(2, null, null), null);
        TreeNode case22 = new TreeNode(1, null, new TreeNode(2, null, null));

        isSameTree(case1, case11);
        isSameTree(case2, case22);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Queue result1 = new LinkedList();
        Queue result2 = new LinkedList();

        bfs(p, list1, result1);
        bfs(q, list2, result2);

        return list1.equals(list2);
    }

    public static void bfs(TreeNode p, List<Integer> list, Queue queue) {
        if (p == null) {
            list.add(null);
            return;
        }
        list.add(p.val);
        queue.add(p.left);
        queue.add(p.right);

        bfs(p.left, list, queue);
        bfs(p.right, list, queue);
    }

    public boolean isSameTreeBest(TreeNode p, TreeNode q) {
        if (p == null || q == null) return (p == q);
        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}

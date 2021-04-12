package top50_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        this.val = x;
    }
}

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree a = new MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);
        root.left.left.left = new TreeNode(7);
        System.out.println(a.maxDepth(root));
        System.out.println(a.dfsStack(root));
        System.out.println(a.bfsQueue(root));

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        System.out.println(root.val);
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
//        System.out.println(leftMax + " / "+ rightMax);

        return Math.max(leftMax, rightMax) + 1;
    }

    public int dfsStack(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();

        stack.push(root);
        value.push(1);
        int max = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int count = value.pop();
            max = Math.max(max, count);

            if(node.left != null) {
                stack.push(node.left);
                value.push(1 + count);
            }
            if(node.right != null) {
                stack.push(node.right);
                value.push(1 + count);
            }

        }

        return max;
    }

    public int bfsQueue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }

        return count;
    }
}

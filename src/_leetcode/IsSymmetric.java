package _leetcode;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsSymmetric {
    public static void main(String[] args) {
        new IsSymmetric().isSymmetric(new TreeNode());
    }
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        return searchBFS(queue, 0);
    }

    public boolean searchBFS(Queue<TreeNode> queue, int depth) {
        if (queue == null || queue.isEmpty()) return true;

        List<TreeNode> nodeList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode pollNode = queue.poll();
            nodeList.add(pollNode);
        }

        int left = 0;
        int right = nodeList.size()-1;
        while (left <= right) {
            TreeNode lNode = nodeList.get(left++);
            TreeNode rNode = nodeList.get(right--);
            if (lNode == null && rNode == null) continue;
            else if (lNode == null && rNode != null) return false;
            else if (lNode != null && rNode == null) return false;
            else if (lNode.val != rNode.val) return false;
        }

        for(TreeNode node : nodeList) {
            if (node == null) continue;
            queue.add(node.left);
            queue.add(node.right);
        }

        return searchBFS(queue, depth+1);
    }
}

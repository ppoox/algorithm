package leetcode;

public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        TreeNode f = new TreeNode(5);
        TreeNode th = new TreeNode(3, f, null);
        TreeNode tw = new TreeNode(2);
        TreeNode root1 = new TreeNode(1, th, tw);

        TreeNode fo = new TreeNode(4);
        TreeNode se = new TreeNode(7);
        TreeNode on = new TreeNode(1, null, fo);
        TreeNode th2 = new TreeNode(3, null, se);
        TreeNode root2 = new TreeNode(2, on, th2);

        TreeNode resultNode = new MergeTwoBinaryTrees().mergeTrees(root1, root2);

        System.out.println(resultNode.val + " " + resultNode.left.val + " " + resultNode.right.val);
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 != null && root2 == null) {
            return new TreeNode(root1.val, mergeTrees(root1.left, null), mergeTrees(root1.right, null));
        } else if (root1 == null && root2 != null) {
            return new TreeNode(root2.val, mergeTrees(null, root2.left), mergeTrees(null, root2.right));
        } else {
            return new TreeNode(root1.val + root2.val, mergeTrees(root1.left, root2.left), mergeTrees(root1.right, root2.right));
        }
    }
}

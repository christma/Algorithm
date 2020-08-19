package com.spring.leetCode;

public class Solution0404 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }
        return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.right) && isBalanced(root.left);
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(dfs(node.left), dfs(node.right)) + 1;
    }
}

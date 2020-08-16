package com.spring.leetCode;

public class Solution404 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {

        return sumOfLeftLeaves(root, false);
    }

    public int sumOfLeftLeaves(TreeNode node, boolean flag) {
        if (node == null) {
            return 0;
        }
        if (flag && node.left == null && node.right == null) {
            return node.val;
        }
        int lsum = sumOfLeftLeaves(node.left, true);
        int rsum = sumOfLeftLeaves(node.right, false);

        return lsum + rsum;
    }
}

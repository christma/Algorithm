package com.spring.leetCode;

public class Solution437 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int sum) {

        if (root == null) {
            return 0;
        }
        int res = countSum(root, sum);
        int lres = pathSum(root.left, sum);
        int rres = pathSum(root.right, sum);
        return res + lres + rres;
    }

    private int countSum(TreeNode node, int sum) {

        if (node == null) {
            return 0;
        }
        sum = sum - node.val;
        int res = sum == 0 ? 1 : 0;
        return res + countSum(node.left, sum) + countSum(node.right, sum);
    }
}

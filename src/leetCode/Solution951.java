package com.spring.leetCode;

import java.util.LinkedList;
import java.util.List;

public class Solution951 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        List<Integer> ans1 = new LinkedList<>();
        List<Integer> ans2 = new LinkedList<>();
        dfs(root1, ans1);
        dfs(root2, ans2);
        return ans1.equals(ans2);

    }

    private void dfs(TreeNode node, List<Integer> ans) {
        if (node != null) {
            ans.add(node.val);
            int L = node.left != null ? node.left.val : -1;
            int R = node.right != null ? node.right.val : -1;
            if (L > R) {
                dfs(node.right, ans);
                dfs(node.left, ans);
            } else {
                dfs(node.left, ans);
                dfs(node.right, ans);
            }
        }
        ans.add(null);
    }
}

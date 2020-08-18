package com.spring.leetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution1110 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<TreeNode> ans;
    Set<Integer> set;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        ans = new LinkedList<>();
        set = new HashSet<>();

        if (root == null) {
            return ans;
        }

        for (int del : to_delete) {
            set.add(del);
        }
        root = dfs(root);

        if (root != null) {
            ans.add(root);
        }
        return ans;
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if (set.contains(root.val)) {
            if (root.left != null) {
                ans.add(root.left);
            }

            if (root.right != null) {
                ans.add(root.right);
            }
            return null;
        }
        return root;
    }
}

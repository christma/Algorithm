package com.spring.leetCode;

import java.util.LinkedList;
import java.util.List;

public class Solution102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        if (root != null) {
            queue.addLast(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                temp.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}

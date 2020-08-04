package com.spring.leetCode;


import java.util.HashMap;
import java.util.Map;

public class Solution1038 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        Map<Integer,Integer> x = new HashMap<>();


        if (root != null) {
            bstToGst(root.right);
            sum = sum + root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
    }
}

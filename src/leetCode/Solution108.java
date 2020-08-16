package com.spring.leetCode;


public class Solution108 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return transform(nums, 0, nums.length - 1);


    }

    private TreeNode transform(int[] nums, int l, int r) {

        if (l > r) {
            return null;
        }
        int mid = (r + l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = transform(nums, l, mid - 1);
        node.right = transform(nums, mid + 1, r);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        Solution108 solution108 = new Solution108();
        solution108.sortedArrayToBST(nums);
    }


}

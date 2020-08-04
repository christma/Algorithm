package com.spring.leetCode;

public class Solution1367 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isSubPath(ListNode head, TreeNode root) {
            if (head == null) {
                return true;
            }
            if (root == null) {
                return false;
            }

            return isSub(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
        }

        private boolean isSub(ListNode head, TreeNode root) {
            if (head == null) {
                return true;
            }
            if (root == null) {
                return false;
            }
            if (head.val != root.val) {
                return false;
            }

            return isSub(head.next, root.left) || isSub(head.next, root.right);
        }
    }
}

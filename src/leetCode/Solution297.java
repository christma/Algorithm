package com.spring.leetCode;

import java.util.LinkedList;

public class Solution297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        private void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#").append(",");
                return;
            }
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> ll = new LinkedList();
            for (String s : data.split(",")) {
                ll.addLast(s);
            }
            return deserialize(ll);
        }

        private TreeNode deserialize(LinkedList<String> nodes) {
            if (nodes.isEmpty()) {
                return null;
            }
            String f = nodes.removeFirst();
            if (f.equals("#")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(f));

            root.left = deserialize(nodes);
            root.right = deserialize(nodes);

            return root;
        }

    }

}

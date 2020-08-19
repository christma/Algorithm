package com.spring.leetCode;

import java.util.LinkedList;

public class JSolution37 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(node.val).append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> ll = new LinkedList<>();
        for (String s : data.split(",")) {
            ll.addLast(s);
        }
        return deserialize(ll);
    }

    private TreeNode deserialize(LinkedList<String> node) {
        if (node.isEmpty()) {
            return null;
        }
        String n = node.removeFirst();
        if (n.equals("#")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(n));
        treeNode.left = deserialize(node);
        treeNode.right = deserialize(node);
        return treeNode;
    }
}
